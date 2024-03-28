package harpoonDiver.models.diver;

import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;


public abstract class BaseDiver implements Diver{
    private static final double OXYGEN_DROP = 30.00;
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    protected BaseDiver ( String name, double oxygen ) {
        this.setName ( name );
        this.setOxygen ( oxygen );
        this.setSeaCatch (  );
    }

    private void setName ( String name ) {
        if (null == name || name.trim ().isEmpty ()){
            throw new NullPointerException ( ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY );
        }
        this.name = name;
    }

    private void setOxygen ( double oxygen ) {
        if (oxygen < 0 ){
            throw new IllegalArgumentException ( ExceptionMessages. DIVER_OXYGEN_LESS_THAN_ZERO  );
        }
        this.oxygen = oxygen;
    }

    private void setSeaCatch ( ) {
        this.seaCatch = new BaseSeaCatch ();

    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public double getOxygen () {
        return this.oxygen;
    }

    @Override
    public boolean canDive () {
        return this.oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch () {
        return this.seaCatch;
    }

    @Override
    public void shoot (){
        setOxygen ( Math.max ( this.oxygen - OXYGEN_DROP,0.00));
    }
}
