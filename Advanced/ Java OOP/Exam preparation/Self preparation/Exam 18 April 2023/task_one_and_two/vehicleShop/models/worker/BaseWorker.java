package vehicleShop.models.worker;

import vehicleShop.common.ExceptionThrower;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static vehicleShop.common.ExceptionMessages.*;

public abstract class BaseWorker implements Worker {
    private static final String TEMPLATE = "Name: %s, Strength: %d%nTools: %d fit left";
    private String name;
    private int strength;
    private Collection<Tool> tools;

    public BaseWorker ( String name, int strength ) {
        this.setName ( name );
        this.setStrength ( strength );
        this.setTools ();
    }
    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name, WORKER_NAME_NULL_OR_EMPTY );
        this.name = name;
    }

    private void setStrength ( int strength ) {
        ExceptionThrower.throwIfNumberIsNegative ( strength, WORKER_STRENGTH_LESS_THAN_ZERO );
        this.strength = strength;
    }

    private void setTools ( ) {
        this.tools = new ArrayList<> (  );
    }

    @Override
    public void working (){
        int strengthAfterWork =  Math.max ( 0, this.strength - this.getStrengthDrop () );

        this.setStrength ( strengthAfterWork);
    }

    @Override
    public void addTool ( Tool tool ) {
        this.tools.add ( tool );
    }

    @Override
    public boolean canWork () {
        return this.strength > 0;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public int getStrength () {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools () {
        return Collections.unmodifiableCollection ( this.tools);
    }
    protected abstract int getStrengthDrop();

    @Override
    public String toString () {

        return String.format ( TEMPLATE,
                this.name,
                this.strength,
                this.tools.stream ()
                        .filter ( t-> !t.isUnfit () )
                        .count ());
    }
}
