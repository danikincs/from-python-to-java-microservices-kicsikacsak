package db_connector;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by doramedgyasszay on 2017. 01. 10..
 */
public interface DataBaseConnector {

    Connection getConnection() throws SQLException;

    void executeQuery(String query);
}
