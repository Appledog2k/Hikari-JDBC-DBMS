package appledog.research.connector;

import appledog.research.service.DatabaseClientService;
import appledog.research.utils.PropertiesFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.NoSuchPaddingException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;

public class DbClientConnection implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(DbClientConnection.class);
    private DatabaseClientService databaseClientService = null;
    private final Properties properties;
    public DbClientConnection(String configPath) {
        this.properties = PropertiesFileReader.readConfig(configPath);
    }

    public DatabaseClientService getDatabaseClientService() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        if (databaseClientService == null) {
            databaseClientService = new DatabaseClientService(properties);
            logger.info("create new DatabaseClientService success");
        }
        return databaseClientService;
    }
    public void close() {
        if (databaseClientService != null) {
            databaseClientService.disable();
            logger.info("disable databaseClientService success");
        }
    }
}
