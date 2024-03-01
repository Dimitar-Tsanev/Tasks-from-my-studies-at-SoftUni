package telephony;

import java.util.List;

class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone ( List<String> numbers, List<String> urls ) {
        this.numbers = numbers;
        this.urls = urls;
    }
    @Override
    public String browse () {
        StringBuilder brows = new StringBuilder ( );

        for ( String url : this.urls ) {
            if ( url.matches ( "\\D+" ) ) {
                brows.append ( "Browsing: " ).append ( url ).append ( "!" ).append ( System.lineSeparator ( ) );
            } else {
                brows.append ( "Invalid URL!" ).append ( System.lineSeparator ( ) );
            }
        }
        return brows.toString ( );
    }

    @Override
    public String call () {
        StringBuilder calls = new StringBuilder ( );
        for ( String number : this.numbers ) {
            if ( number.matches ( "\\d+" ) ) {
                calls.append ( "Calling... " ).append ( number ).append ( System.lineSeparator ( ) );
            } else {
                calls.append ( "Invalid number!" ).append ( System.lineSeparator ( ) );
            }
        }
        return calls.toString ( );
    }
}
