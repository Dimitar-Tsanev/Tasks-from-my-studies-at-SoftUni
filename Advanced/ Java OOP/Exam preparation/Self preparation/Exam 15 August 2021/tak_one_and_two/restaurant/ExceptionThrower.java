package restaurant;

public class ExceptionThrower {
    private ExceptionThrower () {
    }

    public static void throwIfEmptyString ( String string, String exceptionMessage ) {
        if ( string == null || string.trim ( ).isEmpty ( ) ) {
            throw new IllegalArgumentException ( exceptionMessage );
        }
    }

    public static void throwIfNumberIsLesOrZero ( double number, String exceptionMessage ) {
        if ( number <= 0 ) {
            throw new IllegalArgumentException ( exceptionMessage );
        }
    }

}
