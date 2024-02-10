package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop ( int capacity ) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<> ();

    }
    public void addVehicle(Vehicle vehicle){
        if (this.capacity > this.vehicles.size ()){
            this.vehicles.add ( vehicle );
        }
    }
    public boolean removeVehicle(String vin){
        for ( Vehicle vehicle: vehicles ){
            if (vehicle.getVIN ().equals ( vin )){
                return this.vehicles.remove ( vehicle );
            }
        }
        return false;
    }
    public int getCount(){
        return this.vehicles.size ();

    }

    public Vehicle getLowestMileage(){
        Comparator<Vehicle> mileageComparator = (v1,v2)-> {
            if ( v1.getMileage ( ) > v2.getMileage () ){
                return 1;

            } else if (  v1.getMileage ( ) == v2.getMileage () ) {
                return 0;
            }
            return -1;
        };

        return vehicles.stream ().min ( mileageComparator ).get ();
    }

    public String report(){
        StringBuilder sb = new StringBuilder ();
        sb.append ( System.lineSeparator () );
        vehicles.forEach ( v-> {
            sb.append ( v );
            sb.append ( System.lineSeparator ());
        } ) ;
        return "Vehicles in the preparatory:" + sb;
    }
}
