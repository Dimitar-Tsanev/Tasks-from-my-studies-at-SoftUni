package vehicleShop.common;

import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;

import java.util.Collection;

import static vehicleShop.common.ExceptionMessages.HELPER_DOESNT_EXIST;
import static vehicleShop.common.ExceptionMessages.NO_WORKER_READY;

public class ExceptionThrower {
    private ExceptionThrower () {
    }
    public static void throwIfEmptyString (String string, String exceptionMessage ){
        if (string == null || string.equals("")){
            throw new IllegalArgumentException ( exceptionMessage);
        }
    }
    public static void throwIfNumberIsNegative (double number, String exceptionMessage ){
        if (number < 0){
            throw new IllegalArgumentException ( exceptionMessage);
        }
    }
    public static void throwWhenWorkerDoseNotExist( Repository<Worker> repository, String name ){
        Worker worker = repository.findByName ( name );

        if (worker == null){
            throw new IllegalArgumentException ( HELPER_DOESNT_EXIST );
        }

    }
    public static void throwWhenNoSuitableWorkerForWork( Collection<Worker> workers){
        if (workers.isEmpty ()){
            throw new IllegalArgumentException ( NO_WORKER_READY );
        }

    }
}
