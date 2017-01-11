package db_connector;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by doramedgyasszay on 2017. 01. 10..
 */
public class DataBaseConnectorImpl implements DataBaseConnector {

    private String DATABASE;
    private String DB_USER;
    private String DB_PASSWORD;

    private static DataBaseConnectorImpl connectorInstance = null;

    private DataBaseConnectorImpl() {
    }

    public static DataBaseConnectorImpl getInstance(){
        if (connectorInstance == null){
            connectorInstance = new DataBaseConnectorImpl();
        }
        return connectorInstance;
    }

    public Connection getConnection() throws SQLException {
        Properties props = new Properties();

        //try to load the properties, if its not exist its throws an Error
        try {
            props.load(new FileInputStream("src/main/resources/connection.properties"));
        } catch (IOException e){
            System.out.println("No file found");
        }

        //get the properties from our properties file
        DATABASE = props.getProperty("database");
        DB_USER = props.getProperty("user");
        DB_PASSWORD = props.getProperty("password");
        Connection connection = null;

        //try to connect to the database, throws an error if the user data is invalid
        try {
            connection = DriverManager.getConnection(
                    DATABASE,
                    DB_USER,
                    DB_PASSWORD);
        } catch (Exception e) {
            System.out.println("Invalid connection properties " + e);
        }
        return connection;
    }

    //Query executing method
    public void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ){
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
