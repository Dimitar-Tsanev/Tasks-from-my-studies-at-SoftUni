import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main ( String[] args ) throws SQLException, IOException {
        Connection connector = CustomConnector.getConnection ( "diablo" );

        BufferedReader reader = new BufferedReader ( new InputStreamReader (System.in) );

        String sql = """
                SELECT user_name, first_name, last_name, COUNT(*) AS played_games FROM users u
                JOIN users_games ug
                ON u.id = ug.user_id
                WHERE user_name LIKE ?
                GROUP BY u.id;""";

        PreparedStatement preparedStatement = connector.prepareStatement ( sql );

        System.out.println ( "Enter user name:" );

        preparedStatement.setString ( 1, reader.readLine () );

        ResultSet resultSet = preparedStatement.executeQuery ();

        if (!resultSet.next ()){
            System.out.println ( "No such user exists" );

        }else {
            String userName = resultSet.getString ( "user_name" );
            String firstName =  resultSet.getString ( "first_name" );
            String lastName =  resultSet.getString ( "last_name" );
            int count = resultSet.getInt ( "played_games" );

            System.out.printf ( "User: %s" + System.lineSeparator (), userName);
            System.out.printf ("%s %s has played %d games", firstName, lastName, count);
        }

    }
}
