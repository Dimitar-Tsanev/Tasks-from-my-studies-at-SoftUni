package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer ( int id, String manufacturer, String model, double price, double overallPerformance ) {
        super ( id, manufacturer, model, price, overallPerformance );
        this.setComponents ();
        this.setPeripherals ();
    }

    private void setComponents (  ) {
        this.components = new ArrayList<> ();
    }

    private void setPeripherals (  ) {
        this.peripherals = new ArrayList<> ();
    }

    @Override
    public double getOverallPerformance () {
        double averageComponentPerformance =
                this.components.stream ()
                        .mapToDouble ( Component::getOverallPerformance )
                        .average ()
                        .orElse ( 0 );

        return super.getOverallPerformance ( ) + averageComponentPerformance;
    }

    @Override
    public double getPrice () {
        double componentsPrice = this.components.stream ()
                .mapToDouble ( Product::getPrice )
                .sum ();

        double peripheralsPrice = this.peripherals.stream ()
                .mapToDouble ( Product::getPrice )
                .sum ();



        return super.getPrice ( ) + componentsPrice + peripheralsPrice;
    }

    @Override
    public List<Component> getComponents () {
        return Collections.unmodifiableList ( this.components );
    }

    @Override
    public List<Peripheral> getPeripherals () {
        return Collections.unmodifiableList ( this.peripherals );
    }

    @Override
    public void addComponent ( Component component ) {
        if (this.components.contains ( component ) ){

            throw new IllegalArgumentException (
                    String.format ( ExceptionMessages.EXISTING_COMPONENT,
                            component.getClass ().getSimpleName (),
                            this.getClass ().getSimpleName (),
                            this.getId ()));

        }
        this.components.add ( component );

    }

    @Override
    public Component removeComponent ( String componentType ) {
        Component componentToRemove = null;
        for ( Component component: this.components ){
            if (component.getClass ().getSimpleName ().equals ( componentType )){
                componentToRemove = component;

                break;
            }
        }
        if ( componentToRemove == null ){
            throw new IllegalArgumentException (
                    String.format ( ExceptionMessages.NOT_EXISTING_COMPONENT,
                            componentType,
                            this.getClass ().getSimpleName (),
                            this.getId ()) );
        }
        this.components.remove ( componentToRemove );

        return componentToRemove;
    }

    @Override
    public void addPeripheral ( Peripheral peripheral ) {
        if (this.peripherals.contains ( peripheral ) ){

            throw new IllegalArgumentException (
                    String.format ( ExceptionMessages.EXISTING_PERIPHERAL,
                            peripheral.getClass ().getSimpleName (),
                            this.getClass ().getSimpleName (),
                            this.getId ()));

        }
        this.peripherals.add ( peripheral );
    }

    @Override
    public Peripheral removePeripheral ( String peripheralType ) {
        Peripheral peripheralToRemove = null;
        for ( Peripheral peripheral: this.peripherals ){
            if (peripheral.getClass ().getSimpleName ().equals ( peripheralType )){
                peripheralToRemove = peripheral;

                break;
            }
        }
        if ( peripheralToRemove == null ){
            throw new IllegalArgumentException (
                    String.format ( ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                            peripheralType,
                            this.getClass ().getSimpleName (),
                            this.getId ()) );
        }
        this.peripherals.remove ( peripheralToRemove );

        return peripheralToRemove;
    }

    @Override
    public String toString () {
        StringBuilder report = new StringBuilder ();
        report.append ( super.toString () ).append ( System.lineSeparator () );

        report.append ( String.format (" " +
                    OutputMessages.COMPUTER_COMPONENTS_TO_STRING,
                    this.components.size () ) )
                .append ( System.lineSeparator () );

        this.components.forEach ( c-> report.append ( "  " ).append ( c ).append ( System.lineSeparator () ) );

        report.append ( String.format (" " +
                    OutputMessages.COMPUTER_PERIPHERALS_TO_STRING,
                    this.peripherals.size (),
                    this.getOverallPerformanceOfPeripheral () ))
                .append ( System.lineSeparator () );

        this.peripherals.forEach ( p-> report.append ( "  " ).append ( p ) );

        return report.toString ();
    }
    private double getOverallPerformanceOfPeripheral () {
        return this.peripherals.stream ()
                .mapToDouble ( Product::getOverallPerformance )
                .average ()
                .orElse ( 0 );
    }
}
