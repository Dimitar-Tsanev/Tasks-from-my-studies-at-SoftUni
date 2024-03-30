package onlineShop.core.interfaces;


import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private final Map<Integer, Computer> computers;

    public ControllerImpl () {
        computers = new LinkedHashMap<> ( );
    }

    @Override
    public String addComputer ( String computerType,
                                int id,
                                String manufacturer,
                                String model,
                                double price ) {

        if ( isComputerExists ( id ) ) {
            throw new IllegalArgumentException ( ExceptionMessages.EXISTING_COMPUTER_ID );
        }

        Computer computer;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer ( id, manufacturer, model, price );
                break;
            case "Laptop":
                computer = new Laptop ( id, manufacturer, model, price );
                break;
            default:
                throw new IllegalArgumentException ( ExceptionMessages.INVALID_COMPUTER_TYPE );
        }
        this.computers.put ( id, computer );
        return String.format ( OutputMessages.ADDED_COMPUTER, id );
    }

    @Override
    public String addPeripheral ( int computerId,
                                  int id,
                                  String peripheralType,
                                  String manufacturer,
                                  String model,
                                  double price,
                                  double overallPerformance,
                                  String connectionType ) {

        throwExceptionIfComputerIdDoseNotExists ( computerId );

        Computer computer = computers.get ( computerId );

        if ( null != computer.getPeripherals ( ).stream ( )
                .filter ( p -> p.getId ( ) == id )
                .findFirst ( )
                .orElse ( null ) ) {

            throw new IllegalArgumentException ( ExceptionMessages.EXISTING_PERIPHERAL_ID );
        }
        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset ( id, manufacturer, model, price, overallPerformance, connectionType );
                break;
            case "Keyboard":
                peripheral = new Keyboard ( id, manufacturer, model, price, overallPerformance, connectionType );
                break;
            case "Monitor":
                peripheral = new Monitor ( id, manufacturer, model, price, overallPerformance, connectionType );
                break;
            case "Mouse":
                peripheral = new Mouse ( id, manufacturer, model, price, overallPerformance, connectionType );
                break;
            default:
                throw new IllegalArgumentException ( ExceptionMessages.INVALID_PERIPHERAL_TYPE );
        }
        computer.addPeripheral ( peripheral );

        return String.format ( OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId );

    }

    @Override
    public String removePeripheral ( String peripheralType, int computerId ) {
        throwExceptionIfComputerIdDoseNotExists ( computerId );

        Computer computer = computers.get ( computerId );

        Peripheral peripheral = computer.removePeripheral ( peripheralType );

        return String.format ( OutputMessages.REMOVED_PERIPHERAL, peripheralType, peripheral.getId ( ) );
    }

    @Override
    public String addComponent ( int computerId,
                                 int id,
                                 String componentType,
                                 String manufacturer,
                                 String model,
                                 double price,
                                 double overallPerformance,
                                 int generation ) {


        throwExceptionIfComputerIdDoseNotExists ( computerId );

        Computer computer = computers.get ( computerId );

        if ( null != computer.getComponents ( ).stream ( )
                .filter ( c -> c.getId ( ) == id )
                .findFirst ( )
                .orElse ( null ) ) {

            throw new IllegalArgumentException ( ExceptionMessages.EXISTING_COMPONENT_ID );
        }
        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit ( id, manufacturer, model, price, overallPerformance, generation );
                break;
            case "Motherboard":
                component = new Motherboard ( id, manufacturer, model, price, overallPerformance, generation );
                break;
            case "PowerSupply":
                component = new PowerSupply ( id, manufacturer, model, price, overallPerformance, generation );
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory ( id, manufacturer, model, price, overallPerformance, generation );
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive ( id, manufacturer, model, price, overallPerformance, generation );
                break;
            case "VideoCard":
                component = new VideoCard ( id, manufacturer, model, price, overallPerformance, generation );
                break;
            default:
                throw new IllegalArgumentException ( ExceptionMessages.INVALID_COMPONENT_TYPE );
        }

        computer.addComponent ( component );

        return String.format ( OutputMessages.ADDED_COMPONENT, componentType, id, computerId );
    }

    @Override
    public String removeComponent ( String componentType, int computerId ) {
        throwExceptionIfComputerIdDoseNotExists ( computerId );

        Computer computer = computers.get ( computerId );

        Component component = computer.removeComponent ( componentType );

        return String.format ( OutputMessages.REMOVED_COMPONENT, componentType, component.getId ( ) );
    }

    @Override
    public String buyComputer ( int id ) {
        throwExceptionIfComputerIdDoseNotExists ( id );
        return this.computers.remove ( id ).toString ( ).trim ( );
    }

    @Override
    public String BuyBestComputer ( double budget ) {
        Computer computer;
        if ( !computers.isEmpty ( ) ) {
            List<Computer> sortedByPerformance = computers.values ( )
                    .stream ( ).
                    sorted ( Comparator.comparingDouble ( Product::getOverallPerformance ) )
                    .collect ( Collectors.toList ( ) );
            Collections.reverse ( sortedByPerformance );
            computer = sortedByPerformance.stream ( )
                    .filter ( c -> c.getPrice ( ) <= budget )
                    .findFirst ( )
                    .orElse ( null );

            if ( computer != null ) {
                computers.remove ( computer.getId ( ) );
                return computer.toString ( );
            }
        }
        throw new IllegalArgumentException ( String.format ( ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget ) );
    }

    @Override
    public String getComputerData ( int id ) {
        throwExceptionIfComputerIdDoseNotExists ( id );
        return this.computers.get ( id ).toString ( ).trim ( );
    }

    private boolean isComputerExists ( int id ) {
        return computers.containsKey ( id );
    }

    private void throwExceptionIfComputerIdDoseNotExists ( int id ) {
        if ( !isComputerExists ( id ) ) {
            throw new IllegalArgumentException ( ExceptionMessages.NOT_EXISTING_COMPUTER_ID );
        }

    }
}
