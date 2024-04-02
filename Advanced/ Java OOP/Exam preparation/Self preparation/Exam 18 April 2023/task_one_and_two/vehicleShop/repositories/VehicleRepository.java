package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class VehicleRepository implements Repository<Vehicle>{
    private final Map<String, Vehicle> vehicles;

    public VehicleRepository (  ) {
        this.vehicles = new LinkedHashMap<> ( );
    }

    @Override
    public Collection<Vehicle> getWorkers () {
        return Collections.unmodifiableCollection ( this.vehicles.values ());
    }

    @Override
    public void add ( Vehicle model ) {
        this.vehicles.put ( model.getName (),model );
    }

    @Override
    public boolean remove ( Vehicle model ) {
        return this.vehicles.remove ( model.getName (),model );
    }

    @Override
    public Vehicle findByName ( String name ) {
        return this.vehicles.get ( name );
    }
}
