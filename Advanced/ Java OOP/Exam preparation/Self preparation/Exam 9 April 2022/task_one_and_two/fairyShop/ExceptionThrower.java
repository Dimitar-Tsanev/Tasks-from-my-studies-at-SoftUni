package fairyShop;

import fairyShop.models.helper.Helper;

import java.util.List;

import static fairyShop.common.ExceptionMessages.HELPER_DOESNT_EXIST;
import static fairyShop.common.ExceptionMessages.NO_HELPER_READY;

public class ExceptionThrower {
    private ExceptionThrower () {
    }

    public static void throwIfEmptyString ( String string, String exceptionMessage ) {
        if ( string == null || string.trim ( ).isEmpty ( ) ) {
            throw new NullPointerException ( exceptionMessage );
        }
    }

    public static void throwIfNumberIsNegative ( double number, String exceptionMessage ) {
        if ( number < 0 ) {
            throw new IllegalArgumentException ( exceptionMessage );
        }
    }

    public static void throwIfHelperDoseNotExist ( Helper helper ) {
        if(helper == null) {
            throw new IllegalArgumentException ( HELPER_DOESNT_EXIST );
        }
    }
    public static void throwIfNoCapableHelpers ( List<Helper> helpers ) {
        if (helpers.isEmpty ()){
            throw new IllegalArgumentException ( NO_HELPER_READY );
        }
    }
}
