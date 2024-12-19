package appledog.research.interfaces;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseClient extends Serializable {
    void disable();

    String callProduce(String produceName, String action, String input) throws SQLException;

    void createTable(String sql) throws SQLException;

    void insertRecord(String sql) throws SQLException;

    void updateRecord(String sql) throws SQLException;
}
