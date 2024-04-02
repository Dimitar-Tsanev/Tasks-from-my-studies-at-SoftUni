package vehicleShop.factories;

import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;

import static vehicleShop.common.ExceptionMessages.WORKER_TYPE_DOESNT_EXIST;

public class WorkerFactory {
    private WorkerFactory () {
    }
    public static Worker createWorker (String type, String name){
        switch (type){
            case "FirstShift":
                return new FirstShift ( name );

            case "SecondShift":
                return new SecondShift ( name );

            default:
                throw new IllegalArgumentException ( WORKER_TYPE_DOESNT_EXIST );

        }
    }
}
