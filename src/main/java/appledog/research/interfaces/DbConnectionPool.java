package appledog.research.interfaces;

import appledog.research.utils.DatabaseType;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnectionPool extends Serializable {
    void onEnable();

    void onDisable();

    Connection getConnection() throws SQLException;

    DatabaseType getDatabaseType();
}
