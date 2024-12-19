package appledog.research.service;

import appledog.research.interfaces.DatabaseClient;
import appledog.research.utils.DatabaseUtils;
import appledog.research.utils.StringConstants;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.SQLException;

public class CallExecuteDbClient implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(CallExecuteDbClient.class);

    public static String callProduce(DatabaseClient databaseClient, JsonObject json) throws SQLException {
        String action = json.getAsJsonObject(StringConstants.USER_DATA).get(StringConstants.MY_ACTION).getAsString();
        JsonObject jsonUserData = json.getAsJsonObject(StringConstants.USER_DATA);
        String produceName = "begin " + StringConstants.PR_OUTPUT_SERVICES + "(?,?,?); end;";

        long startTime = System.currentTimeMillis();
        String responseData = databaseClient.callProduce(produceName, action, json.toString());

        logger.info("callProduce:success callProduce:{}", System.currentTimeMillis() - startTime);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(StringConstants.USER_HEADER, jsonUserData);
        jsonObject.add(StringConstants.DATA, DatabaseUtils.toJsonArray(responseData));
        return jsonObject.toString();
    }
}
