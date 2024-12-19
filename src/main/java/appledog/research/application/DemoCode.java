package appledog.research.application;

import appledog.research.connector.DbClientConnection;
import appledog.research.service.DatabaseClientService;

import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class DemoCode {
    public DemoCode() {
        super();
    }

    public void execute() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SQLException {
        String configPath = System.getProperty("user.dir") + "/config/application.properties";
        DbClientConnection dbClientConnection = new DbClientConnection(configPath);
        DatabaseClientService databaseClient = dbClientConnection.getDatabaseClientService();
        databaseClient.createTable("CREATE TABLE IF NOT EXISTS test_table8386 (id INT PRIMARY KEY, name VARCHAR(255))");
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SQLException {

        DemoCode demoCode = new DemoCode();
        demoCode.execute();
    }
}
