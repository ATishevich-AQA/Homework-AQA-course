package RestApi;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class RestApiTest {
    public static final String MESSAGE = "test message";
    public static final String OWNER_ID = "XXXX";
    public static final String ACCESS_TOKEN = "NNNNNN";

    @Test
    public void postMessageTest() throws IOException, URISyntaxException {
        RestApi restApi = new RestApi();
        int receivedStatusCode = restApi.postMessage(MESSAGE, MESSAGE, OWNER_ID, ACCESS_TOKEN);
        int statusCode = 200;
        Assert.assertEquals(statusCode, receivedStatusCode);
    }
}