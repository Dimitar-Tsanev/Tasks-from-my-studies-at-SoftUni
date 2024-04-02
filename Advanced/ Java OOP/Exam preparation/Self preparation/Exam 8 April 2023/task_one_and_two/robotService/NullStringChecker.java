package robotService;

public class NullStringChecker {
    private NullStringChecker () {
    }
    public static void throwExceptionIfStringNullOrEmpty ( String string, String exceptionMessage ) {
        if ( string == null || string.trim ( ).isEmpty ( ) ) {
            throw new NullPointerException ( exceptionMessage );
        }
    }
}
