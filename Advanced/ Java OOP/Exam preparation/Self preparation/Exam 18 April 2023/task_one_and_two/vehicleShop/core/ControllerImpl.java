package vehicleShop.core;

import vehicleShop.common.ExceptionThrower;
import vehicleShop.factories.WorkerFactory;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private final Repository<Worker> workerRepository;
    private final Repository<Vehicle> vehicleRepository;
    private int madeVehicles;

    public ControllerImpl () {
        this.workerRepository = new WorkerRepository ( );
        this.vehicleRepository = new VehicleRepository ( );
    }

    @Override
    public String addWorker ( String type, String workerName ) {
        this.workerRepository.add ( WorkerFactory.createWorker ( type, workerName ) );

        return String.format ( ADDED_WORKER, type, workerName );
    }

    @Override
    public String addVehicle ( String vehicleName, int strengthRequired ) {
        this.vehicleRepository.add ( new VehicleImpl ( vehicleName, strengthRequired ) );

        return String.format ( SUCCESSFULLY_ADDED_VEHICLE, vehicleName );
    }

    @Override
    public String addToolToWorker ( String workerName, int power ) {
        ExceptionThrower.throwWhenWorkerDoseNotExist ( workerRepository, workerName );

        Tool tool = new ToolImpl ( power );

        workerRepository.findByName ( workerName ).addTool ( tool );

        return String.format ( SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName );
    }

    @Override
    public String makingVehicle ( String vehicleName ) {
        List<Worker> assignWorkers = this.workerRepository.getWorkers ( )
                .stream ( )
                .filter ( w -> w.getStrength ( ) > 70 )
                .collect ( Collectors.toList ( ) );

        ExceptionThrower.throwWhenNoSuitableWorkerForWork ( assignWorkers );

        Vehicle vehicle = this.vehicleRepository.findByName ( vehicleName );

        Shop shop = new ShopImpl ( );
        long brokenTools = 0;
        for ( Worker worker : assignWorkers ) {
            shop.make ( vehicle, worker );

            brokenTools += worker.getTools ( )
                    .stream ( )
                    .filter ( Tool::isUnfit )
                    .count ( );
        }
        String isReady = String.format (
                VEHICLE_DONE, vehicle.getName ( ),
                vehicle.reached ( ) ? "done" : "not done" );

        madeVehicles += vehicle.reached ( ) ? 1 : 0;

        String toolsDamageReport = String.format ( COUNT_BROKEN_INSTRUMENTS, brokenTools );

        return isReady + toolsDamageReport;
    }

    @Override
    public String statistics () {
        StringBuilder reportBuilder = new StringBuilder ();
        reportBuilder.append ( String.format ( "%d vehicles are ready!",
                        this.madeVehicles ))
                .append ( System.lineSeparator () );

        reportBuilder.append ( "Info for workers:" )
                .append ( System.lineSeparator () );

        this.workerRepository.getWorkers ()
                .forEach ( w ->
                        reportBuilder.append ( w.toString () )
                        .append ( System.lineSeparator () ));

        return reportBuilder.toString ().trim ();
    }
}
