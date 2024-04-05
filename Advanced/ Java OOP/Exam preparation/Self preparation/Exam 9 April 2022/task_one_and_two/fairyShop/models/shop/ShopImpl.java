package fairyShop.models.shop;

import fairyShop.models.helper.Helper;
import fairyShop.models.instruments.Instrument;
import fairyShop.models.present.Present;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShopImpl implements Shop {
    @Override
    public void craft ( Present present, Helper helper ) {
        Deque<Instrument> currentInstruments = new ArrayDeque<> ( );

        helper.getInstruments ( ).forEach ( currentInstruments::offer );

        Instrument instrument;

        while (!currentInstruments.isEmpty ( )) {
            if ( currentInstruments.peek ( ).isBroken ( ) ) {
                currentInstruments.poll ( );
                continue;
            }

            instrument = currentInstruments.peek ( );

            if ( !present.isDone ( ) && helper.canWork ( ) ) {
                helper.work ( );
                instrument.use ( );
                present.getCrafted ( );

            } else {
                break;

            }
        }
    }
}
