package appledog.research.standard;

import appledog.research.utils.DatabaseUtils;

import javax.crypto.NoSuchPaddingException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class StandardParserConfig implements Serializable {
    public static Map<PropertyDescriptor, String> parserDb(Properties properties) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        Map<PropertyDescriptor, String> mapProps = new HashMap<>();

        String connectionString = properties.getProperty("dataSource.uri");
        String user = properties.getProperty("dataSource.user");
        String password = properties.getProperty("dataSource.password");
        String minimumIdle = properties.getProperty("dataSource.minimum.idle");
        String poolSize = properties.getProperty("dataSource.pool.size");
        String cachePrepStmts = properties.getProperty("dataSource.cachePrepStmts");
        String prepStmtCacheSize = properties.getProperty("dataSource.prepStmtCacheSize");
        String prepStmtCacheSqlLimit = properties.getProperty("dataSource.prepStmtCacheSqlLimit");
        String[] splitConnectionString = connectionString.split(":");
        mapProps.put(DatabaseUtils.DATABASE_TYPE,splitConnectionString[1]);
        switch (splitConnectionString[1]) {
            case "mysql":
                mapProps.put(DatabaseUtils.DRIVER, "com.mysql.jdbc.Driver");
                break;
            case "postgresql":
                mapProps.put(DatabaseUtils.DRIVER, "org.postgresql.Driver");
                break;
            case "sqlserver":
                mapProps.put(DatabaseUtils.DRIVER, "com.microsoft.sqlserver");
                break;
            default:
                mapProps.put(DatabaseUtils.DRIVER, "oracle.jdbc.driver.OracleDriver");
                break;

        }
        mapProps.put(DatabaseUtils.CONNECTION_STRING, connectionString);
        mapProps.put(DatabaseUtils.USER, user);
        mapProps.put(DatabaseUtils.PASSWORD, password);
        mapProps.put(DatabaseUtils.MINIMUM_IDLE, minimumIdle);
        mapProps.put(DatabaseUtils.POOL_SIZE, poolSize);
        mapProps.put(DatabaseUtils.CACHE_PREP_STMTS, cachePrepStmts);
        mapProps.put(DatabaseUtils.PREP_STMTS_CACHE_SIZE, prepStmtCacheSize);
        mapProps.put(DatabaseUtils.PREP_STMTS_CACHE_SQL_LIMIT, prepStmtCacheSqlLimit);
        return mapProps;
    }

}
