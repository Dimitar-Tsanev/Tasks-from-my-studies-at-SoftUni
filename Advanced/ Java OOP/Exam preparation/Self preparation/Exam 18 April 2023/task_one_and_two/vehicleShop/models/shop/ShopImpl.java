package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShopImpl implements Shop {
    @Override
    public void make ( Vehicle vehicle, Worker worker ) {
        Deque<Tool> tools = new ArrayDeque<> ( );
        worker.getTools ( ).forEach ( tools::offer );


        while (!tools.isEmpty ( ) ) {
            Tool tool = tools.peek ( );

            while (!tool.isUnfit () && !vehicle.reached ( ) && worker.canWork ( )) {
                worker.working ( );
                vehicle.making ( );
                tool.decreasesPower ( );
            }
            if (vehicle.reached () || !worker.canWork ()){
                break;
            }
            if (tool.isUnfit ()){
                tools.poll ();
            }
        }
    }
}
