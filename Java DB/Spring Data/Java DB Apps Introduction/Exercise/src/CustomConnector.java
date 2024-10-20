import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

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
        Path dbConfig = Paths.get ( getDbConfigPath () );

        List<String> dataLinesToList = Files.readAllLines ( dbConfig );

        String port = dataLinesToList.get ( 0 );

        Properties properties = new Properties();
        properties.setProperty("user", dataLinesToList.get ( 1 ));
        properties.setProperty("password", dataLinesToList.get ( 2 ));

        String url = String.format ( JDBC_URL_TEMPLATE,port, dbName );

        connection = DriverManager.getConnection ( url,properties);
    }

    private static String getDbConfigPath () throws IOException {
        System.out.println ( "Enter path:" );
        return reader.readLine ( );
    }
}
