package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.Repository;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository supplements;
    private Collection<Service> services;

    public ControllerImpl (  ) {
        this.supplements = new SupplementRepository ( );
        this.services = new ArrayList<> ( );
    }

    @Override
    public String addService ( String type, String name ) {
        Service service = createService ( type, name );

        this.services.add ( service );

        return String.format ( SUCCESSFULLY_ADDED_SERVICE_TYPE, service.getClass ( ).getSimpleName ( ) );
    }

    @Override
    public String addSupplement ( String type ) {
        Supplement supplement = createSupplement ( type );

        this.supplements.addSupplement ( supplement );

        return String.format ( SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, supplement.getClass ( ).getSimpleName ( ) );
    }

    @Override
    public String supplementForService ( String serviceName, String supplementType ) {
        Supplement supplement = this.supplements.findFirst ( supplementType );

        Service service = getService ( serviceName );

        if ( supplement != null && service != null ) {
            service.addSupplement ( supplement );
            this.supplements.removeSupplement ( supplement );

            return String.format ( SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE,
                    supplement.getClass ( ).getSimpleName ( ),
                    service.getName ( ) );
        }
        throw new IllegalArgumentException ( String.format ( NO_SUPPLEMENT_FOUND, supplementType ) );
    }

    @Override
    public String addRobot ( String serviceName, String robotType, String robotName, String robotKind, double price ) {
        Robot robot = createRobot ( robotType, robotName, robotKind, price );
        Service service = getService ( serviceName );

        if ( isCorrectServiceForRobot ( service, robot ) ) {
            service.addRobot ( robot );

            return String.format ( SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE,
                    robot.getClass ( ).getSimpleName ( ),
                    service.getName ( ) );
        }

        return UNSUITABLE_SERVICE;
    }

    @Override
    public String feedingRobot ( String serviceName ) {
        Service service = getService ( serviceName );
        service.feeding ( );

        return String.format ( FEEDING_ROBOT, service.getRobots ( ).size ( ) );
    }

    @Override
    public String sumOfAll ( String serviceName ) {
        Service service = getService ( serviceName );

        double robotsPrice = service.getRobots ( )
                .stream ( )
                .mapToDouble ( Robot::getPrice )
                .sum ( );

        double supplementsPrice = service.getSupplements ( )
                .stream ( )
                .mapToDouble ( Supplement::getPrice )
                .sum ( );

        return String.format ( VALUE_SERVICE, service.getName ( ), robotsPrice + supplementsPrice );
    }

    @Override
    public String getStatistics () {
        StringBuilder report = new StringBuilder ( );

        this.services.forEach ( s -> report.append ( s.getStatistics ( ) ).append ( System.lineSeparator ( ) ) );

        return report.toString ( ).trim ( );
    }

    private static Service createService ( String type, String name ) {
        switch (type) {
            case "MainService":
                return new MainService ( name );
            case "SecondaryService":
                return new SecondaryService ( name );
            default:
                throw new NullPointerException ( INVALID_SERVICE_TYPE );
        }
    }

    private static Supplement createSupplement ( String type ) {
        switch (type) {
            case "MetalArmor":
                return new MetalArmor ( );
            case "PlasticArmor":
                return new PlasticArmor ( );
            default:
                throw new IllegalArgumentException ( INVALID_SUPPLEMENT_TYPE );
        }
    }

    private static Robot createRobot ( String type, String robotName, String robotKind, double price ) {
        switch (type) {
            case "FemaleRobot":
                return new FemaleRobot ( robotName, robotKind, price );
            case "MaleRobot":
                return new MaleRobot ( robotName, robotKind, price );
            default:
                throw new IllegalArgumentException ( INVALID_ROBOT_TYPE );
        }
    }

    private Service getService ( String serviceName ) {
        return this.services.stream ( )
                .filter ( s -> serviceName.equals ( s.getName ( ) ) )
                .findFirst ( )
                .orElse ( null );
    }

    private boolean isCorrectServiceForRobot ( Service service, Robot robot ) {
        if ( service instanceof SecondaryService ) {
            return robot instanceof FemaleRobot;

        } else if ( service instanceof MainService ) {
            return robot instanceof MaleRobot;

        } else {
            return false;
        }
    }
}
