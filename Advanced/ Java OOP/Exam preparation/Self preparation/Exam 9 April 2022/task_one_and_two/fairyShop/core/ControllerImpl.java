package fairyShop.core;

import fairyShop.ExceptionThrower;
import fairyShop.models.helper.Happy;
import fairyShop.models.helper.Helper;
import fairyShop.models.helper.Sleepy;
import fairyShop.models.instruments.Instrument;
import fairyShop.models.instruments.InstrumentImpl;
import fairyShop.models.present.Present;
import fairyShop.models.present.PresentImpl;
import fairyShop.models.shop.Shop;
import fairyShop.models.shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.HELPER_TYPE_DOESNT_EXIST;

public class ControllerImpl implements Controller {
    private Repository<Helper> helperRepository;
    private Repository<Present> presentRepository;
    private int donePresents;

    @Override
    public String addHelper ( String type, String helperName ) {
        if ( this.helperRepository == null ) {
            this.helperRepository = new HelperRepository ( );
        }
        Helper helper = createHelper ( type, helperName );

        this.helperRepository.add ( helper );

        return String.format ( ADDED_HELPER, helper.getClass ( ).getSimpleName ( ), helper.getName ( ) );
    }

    @Override
    public String addInstrumentToHelper ( String helperName, int power ) {
        Helper helper = this.helperRepository.findByName ( helperName );

        ExceptionThrower.throwIfHelperDoseNotExist ( helper );

        helper.addInstrument ( new InstrumentImpl ( power ) );

        return String.format ( SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helper.getName ( ) );
    }

    @Override
    public String addPresent ( String presentName, int energyRequired ) {
        if ( this.presentRepository == null ) {
            this.presentRepository = new PresentRepository ( );
        }
        this.presentRepository.add ( new PresentImpl ( presentName, energyRequired ) );

        return String.format ( SUCCESSFULLY_ADDED_PRESENT, presentName );
    }

    @Override
    public String craftPresent ( String presentName ) {
        Present present = this.presentRepository.findByName ( presentName );

        List<Helper> capableHelpers = this.helperRepository.getModels ( )
                .stream ( )
                .filter ( h -> h.getEnergy ( ) > 50 )
                .collect ( Collectors.toList ( ) );

        ExceptionThrower.throwIfNoCapableHelpers ( capableHelpers );
        long brokenInstruments = 0;
        Shop shop = new ShopImpl ( );

        for ( Helper helper : capableHelpers ) {
            shop.craft ( present, helper );

            brokenInstruments += helper.getInstruments ( )
                    .stream ( )
                    .filter ( Instrument::isBroken )
                    .count ( );

            if ( present.isDone ( ) ) {
                break;
            }
        }
        String presentInfo = String.format ( PRESENT_DONE,
                present.getName ( ),
                present.isDone ( ) ?
                        "done" :
                        "not done" );

        donePresents += present.isDone ( ) ? 1 : 0;


        String instrumentReport = String.format ( COUNT_BROKEN_INSTRUMENTS, brokenInstruments );

        return presentInfo + instrumentReport;
    }

    @Override
    public String report () {
        StringBuilder report = new StringBuilder ( );

        report.append ( String.format ( "%d presents are done!", donePresents ) )
                .append ( System.lineSeparator ( ) );

        report.append ( "Helpers info:" ).append ( System.lineSeparator ( ) );

        this.helperRepository.getModels ( ).forEach ( h -> report.append ( h.toString ( ) ).append ( System.lineSeparator ( ) ) );

        return report.toString ( ).trim ( );
    }

    private static Helper createHelper ( String type, String name ) {
        switch (type) {
            case "Sleepy":
                return new Sleepy ( name );

            case "Happy":
                return new Happy ( name );

            default:
                throw new IllegalArgumentException ( HELPER_TYPE_DOESNT_EXIST );
        }
    }
}
