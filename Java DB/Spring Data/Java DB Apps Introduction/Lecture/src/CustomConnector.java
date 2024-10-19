import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class CustomConnector {
    private static final BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );

    private static final String JDBC_URL_TEMPLATE = "jdbc:mysql://localhost:%s/%s";

    private static Connection connection;

    private CustomConnector () {
    }

    public static Connection getConnection ( String dbName ) throws SQLException, IOException {
        if ( connection == null ) {
            createConnection ( dbName );
        }

        return connection;
    }

    private static void createConnection ( String dbName ) throws SQLException, IOException {
        String url = String.format ( JDBC_URL_TEMPLATE,enterPort(), dbName );

        connection = DriverManager.getConnection ( url, enterUser(), enterPassword ( ) );
    }

    private static Object enterPort () throws IOException {
        System.out.println ( "Enter port:" );
        return reader.readLine ( );
    }

    private static String enterUser () throws IOException {
        System.out.println ( "Enter DB User:" );
        return reader.readLine ( );
    }

    private static String enterPassword () throws IOException {
        System.out.println ( "Enter password:" );
        return reader.readLine ( );
    }
}
