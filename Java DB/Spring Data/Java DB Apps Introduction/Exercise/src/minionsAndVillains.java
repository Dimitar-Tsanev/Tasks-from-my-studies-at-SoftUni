import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1.Initial Setup
public class minionsAndVillains {
    private static final String DB_NAME = "minions_db";

    private static final BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
    private static Connection connection;

    public static void main ( String[] args ) throws SQLException, IOException {
        connection = CustomConnector.getConnection ( DB_NAME );

        getVillainsWithMinionsCount ();
        getMinionsByVillainID();
        addMinion ();
        changeTownNameToUpperCase();
        removeVillain ( );
        printAllMinionsNames();
        increaseMinionsAge();
        increaseAgeStoredProcedure();
    }

    //2.Get Villains’ Names
    public static void getVillainsWithMinionsCount () throws SQLException {
        String query = """
                SELECT name, COUNT(*) AS minions_count FROM villains v
                JOIN minions_villains mv\s
                ON v.id = mv.villain_id\s
                GROUP BY v.id\s
                HAVING minions_count > 15\s
                ORDER BY minions_count DESC\s
                """;

        Statement statement = connection.createStatement ( );

        ResultSet resultSet = statement.executeQuery ( query );

        while (resultSet.next ( )) {

            System.out.println ( resultSet.getString ( "name" ) + " " + resultSet.getInt ( "minions_count" ) );
        }
    }

    //3.Get Minion Names
    public static void getMinionsByVillainID () throws SQLException, IOException {
        String query = """
                SELECT v.name, m.name, m.age FROM villains v
                JOIN minions_villains mv
                ON v.id = mv.villain_id
                JOIN minions m
                ON mv.minion_id = m.id
                WHERE v.id = ?;
                """;

        PreparedStatement preparedStatement = connection.prepareStatement ( query );

        int villainID = Integer.parseInt ( reader.readLine ( ) );

        preparedStatement.setInt ( 1, villainID );

        ResultSet resultSet = preparedStatement.executeQuery ( );

        if ( !resultSet.next ( ) ) {
            System.out.printf ( "No villain with ID %d exists in the database.", villainID );


        } else {
            int rowNumber = 1;

            System.out.println ( "Villain: " + resultSet.getString ( "v.name" ) );

            do {
                System.out.printf ( "%d. %s %d%n", rowNumber++, resultSet.getString ( "m.name" ), resultSet.getInt ( "m.age" ) );

            } while (resultSet.next ( ));
        }
    }

    //4.Add Minion
    public static void addMinion () throws IOException, SQLException {
        List<String> minionInformation = Arrays.stream ( reader.readLine ( ).split ( "\\s+" ) ).toList ( );

        String minionName = minionInformation.get ( 1 );
        int minionAge = Integer.parseInt ( minionInformation.get ( 2 ) );
        String minionTown = minionInformation.getLast ( );

        String villainName = Arrays.stream ( reader.readLine ( ).split ( "\\s+" ) ).toList ( ).getLast ( );

        int townId = getTown ( minionTown );
        int VillainID = getVillain ( villainName );

        String insertMinionQuery = "INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?);";

        PreparedStatement insertMinionPreparedStatement = connection.prepareStatement ( insertMinionQuery );

        insertMinionPreparedStatement.setString ( 1, minionName );
        insertMinionPreparedStatement.setInt ( 2, minionAge );
        insertMinionPreparedStatement.setInt ( 3, townId );

        if ( insertMinionPreparedStatement.executeUpdate ( ) != 1 ) {
            throw new SQLException ( "Minion insert failed" );
        }

        int minionId = getMinion ( minionName );

        String query = "INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement ( query );

        preparedStatement.setInt ( 1, minionId );
        preparedStatement.setInt ( 2, VillainID );

        if ( preparedStatement.executeUpdate ( ) != 1 ) {
            throw new SQLException ( "Minion insert failed" );
        }

        System.out.printf ( "Successfully added %s to be minion of %s%n", minionName, villainName );
    }

    private static int getMinion ( String minionName ) throws SQLException {
        String query = """
                SELECT id FROM minions
                WHERE name = ?;
                """;
        PreparedStatement preparedStatement = connection.prepareStatement ( query );

        preparedStatement.setString ( 1, minionName );

        ResultSet resultSet = preparedStatement.executeQuery ( );

        if ( resultSet.next ( ) ) {
            return resultSet.getInt ( "id" );
        }
        throw new SQLException ( "Can't find minion with given name" );
    }

    private static int getTown ( String town ) throws SQLException {
        String query = "SELECT id FROM towns WHERE name = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement ( query );

        preparedStatement.setString ( 1, town );

        ResultSet resultSet = preparedStatement.executeQuery ( );

        if ( resultSet.next ( ) ) {
            return resultSet.getInt ( "id" );
        }

        addTown ( town );
        return getTown ( town );
    }

    private static void addTown ( String town ) throws SQLException {
        String query = "INSERT INTO towns (name) VALUE (?);";

        PreparedStatement preparedStatement = connection.prepareStatement ( query );

        preparedStatement.setString ( 1, town );

        int result = preparedStatement.executeUpdate ( );

        if ( result != 1 ) {
            throw new SQLException ( "Town insert failed" );
        }
        System.out.printf ( "Town %s was added to the database.%n", town );
    }

    private static int getVillain ( String name ) throws SQLException {
        String query = """
                SELECT id FROM villains
                WHERE name = ?;
                """;
        PreparedStatement preparedStatement = connection.prepareStatement ( query );

        preparedStatement.setString ( 1, name );

        ResultSet resultSet = preparedStatement.executeQuery ( );

        if ( resultSet.next ( ) ) {
            return resultSet.getInt ( "id" );
        }

        addVillain ( name );
        return getVillain ( name );
    }

    private static void addVillain ( String name ) throws SQLException {
        String query = "INSERT INTO villains (name, evilness_factor) VALUES (?, 'evil' );";

        PreparedStatement preparedStatement = connection.prepareStatement ( query );

        preparedStatement.setString ( 1, name );

        int result = preparedStatement.executeUpdate ( );

        if ( result != 1 ) {
            throw new SQLException ( "Town insert failed" );
        }

        System.out.printf ( "Villain %s was added to the database.%n", name );
    }

    //5.Change Town Names Casing
    public static void changeTownNameToUpperCase () throws SQLException, IOException {
        String updateQuery = """
                UPDATE towns
                SET name = UPPER(name)
                WHERE country = ?;
                """;

        PreparedStatement updatePreparedStatment = connection.prepareStatement ( updateQuery );

        String country = reader.readLine ( );

        updatePreparedStatment.setString ( 1, country );

        int affectedRows = updatePreparedStatment.executeUpdate ( );

        if ( affectedRows == 0 ) {
            System.out.println ( "No town names were affected." );
            return;
        }

        System.out.printf ( "%d town names were affected.%n", affectedRows );

        String selectQuery = """
                SELECT name FROM towns
                WHERE country = ?;
                """;

        PreparedStatement selectPreparedStatment = connection.prepareStatement ( selectQuery );

        selectPreparedStatment.setString ( 1, country );

        ResultSet resultSet = selectPreparedStatment.executeQuery ( );

        List<String> townsNames = new ArrayList<> ( );

        while (resultSet.next ( )) {
            townsNames.add ( resultSet.getString ( "name" ) );
        }
        System.out.println ( townsNames );
    }

    //6. *Remove Villain
    public static void removeVillain () throws IOException, SQLException {
        int villainID = Integer.parseInt ( reader.readLine ( ) );

        String villainName = getVillainName ( villainID );

        if (villainName.equals ( "No such villain was found" )){
            System.out.println ( "No such villain was found"  );
            return;
        }

        int deletedRows = deleteRelations(villainID);

        String deleteVillainQuery = "DELETE FROM villains WHERE id = ?;";

        PreparedStatement deleteVillain = connection.prepareStatement ( deleteVillainQuery );

        deleteVillain.setInt ( 1, villainID );

        System.out.println ( villainName + " was deleted" );
        System.out.println ( deletedRows + " minions released" );

    }

    private static String getVillainName ( int villainID ) throws SQLException {
        String selectVillainName = "SELECT name FROM villains WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement ( selectVillainName );

        preparedStatement.setInt ( 1, villainID );

        ResultSet resultSetName = preparedStatement.executeQuery ( );

        if ( !resultSetName.next ( ) ) {
            return "No such villain was found";
        }
        return resultSetName.getString ( "name" );
    }

    private static int deleteRelations ( int villainID ) throws SQLException {
        String deleteFromMappingTABLE = "DELETE FROM minions_villains WHERE villain_id = ?;";

        PreparedStatement deleteRelations = connection.prepareStatement ( deleteFromMappingTABLE );

        deleteRelations.setInt ( 1, villainID );

        return deleteRelations.executeUpdate ();
    }

    //7. Print All Minion Names
    public static void printAllMinionsNames () throws SQLException {
        String sql = "SELECT name FROM minions";

        Statement statement = connection.createStatement ();

        ResultSet resultSet = statement.executeQuery ( sql );

        List<String> minionsNames = new ArrayList<> ();

        while (resultSet.next ()){
            minionsNames.add ( resultSet.getString ( "name" ) );
        }

      while (!minionsNames.isEmpty ()){
          System.out.println ( minionsNames.removeFirst ( ) );

          if(!minionsNames.isEmpty ()) {
              System.out.println ( minionsNames.removeLast ( ) );
          }
      }

    }

    //8.Increase Minions Age
    public static void increaseMinionsAge() throws IOException, SQLException {
        String query = """
                UPDATE minions
                SET age = age + 1, name = LOWER(name)
                WHERE id = ?
                """;

        List<Integer> ids = Arrays.stream ( reader.readLine ().split ( "\\s+" ) ).map ( Integer::parseInt ).toList ();

        for ( int id: ids ){
            PreparedStatement preparedStatement = connection.prepareStatement ( query);
            preparedStatement.setInt ( 1,id );

            preparedStatement.executeUpdate ();
        }

        String selectQuery = "SELECT name, age FROM minions";

        Statement statement = connection.createStatement ();

        ResultSet resultSet = statement.executeQuery ( selectQuery );

        while (resultSet.next ()){
            System.out.println ( resultSet.getString ( "name" ) +
                                 " " +
                                resultSet.getInt ( "age" ));
        }
    }

    //9.Increase Age Stored Procedure
    public static void increaseAgeStoredProcedure() throws IOException, SQLException {
        int minionId = Integer.parseInt (  reader.readLine ());

        CallableStatement callableStatement = connection.prepareCall ( "CALL usp_get_older(?)" );

        callableStatement.setInt ( 1, minionId );

        callableStatement.execute ();

        PreparedStatement preparedStatement = connection.prepareStatement ( "SELECT name, age FROM minions WHERE id = ?");

        preparedStatement.setInt ( 1,minionId );

        ResultSet resultSet = preparedStatement.executeQuery ();

        if(resultSet.next ()){
            System.out.println (resultSet.getString ( "name" ) +
                    " " +
                    resultSet.getInt ( "age" ) );
        }
    }
}
