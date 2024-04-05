package fairyShop.models.helper;

import fairyShop.ExceptionThrower;
import fairyShop.models.instruments.Instrument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

public abstract class BaseHelper implements Helper {
    private static final String TEMPLATE = "Name: %s" + System.lineSeparator () +
            "Energy: %s" + System.lineSeparator () +
            "Instruments: %d not broken left";
    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    public BaseHelper ( String name, int energy ) {
        this.setName ( name );
        this.setEnergy ( energy );
        this.setInstruments ( );

    }

    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name, HELPER_NAME_NULL_OR_EMPTY );
        this.name = name;
    }

    private void setEnergy ( int energy ) {
        this.energy = energy;
    }

    private void setInstruments () {
        this.instruments = new ArrayList<> ( );
    }
    protected abstract int getEnergyDrop();

    @Override
    public void work () {
        this.setEnergy ( Math.max ( this.energy - this.getEnergyDrop (), 0 ) );
    }

    @Override
    public void addInstrument ( Instrument instrument ) {
        this.instruments.add ( instrument );
    }

    @Override
    public boolean canWork () {
        return this.energy > 0;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public int getEnergy () {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments () {
        return Collections.unmodifiableCollection ( this.instruments );
    }

    @Override
    public String toString () {

        return String.format ( TEMPLATE,
                this.name,
                this.energy,
                this.instruments.stream ().filter ( i -> !i.isBroken () ).count () );
    }
}
