package robotService.entities.services;

import robotService.NullStringChecker;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;
import static robotService.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService ( String name, int capacity ) {
        this.setName ( name );
        this.setCapacity ( capacity );
        this.setSupplements (  );
        this.setRobots (  );
    }

    private void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }

    private void setSupplements ( ) {
        this.supplements = new ArrayList<> ();
    }

    private void setRobots ( ) {
        this.robots = new ArrayList<> ();
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public void setName ( String name ) {
        NullStringChecker.throwExceptionIfStringNullOrEmpty (
                name,
                SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots () {
        return Collections.unmodifiableCollection ( this.robots);
    }

    @Override
    public Collection<Supplement> getSupplements () {
        return Collections.unmodifiableCollection (this.supplements);
    }

    @Override
    public void addRobot ( Robot robot ) {
        if(this.capacity <= this.robots.size ()){
            throw new IllegalArgumentException ( NOT_ENOUGH_CAPACITY_FOR_ROBOT );
        }
        this.robots.add ( robot );
    }

    @Override
    public void removeRobot ( Robot robot ) {
        this.robots.remove ( robot );

    }

    @Override
    public void addSupplement ( Supplement supplement ) {
        this.supplements.add ( supplement );
    }

    @Override
    public void feeding () {
        this.robots.forEach ( Robot::eating );
    }

    @Override
    public int sumHardness () {
        return this.supplements.stream( ).mapToInt ( Supplement::getHardness ).sum ();
    }

    @Override
    public String getStatistics () {
       String template = "%s %s:" + System.lineSeparator () +
        "Robots: %s" + System.lineSeparator () +
        "Supplements: %s Hardness: %s";

       String robotsInService = this.robots.isEmpty ()? "none" : this.robots.stream ().map ( Robot::getName ).collect ( Collectors.joining ( " " ) );

        return String.format ( template,
                this.name, this.getClass ().getSimpleName (),
                robotsInService,
                this.supplements.size (), this.sumHardness ());
    }
}
