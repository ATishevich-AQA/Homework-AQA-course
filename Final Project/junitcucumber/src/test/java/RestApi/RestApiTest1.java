package RestApi;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class RestApiTest1 {
    public static final String MESSAGE = "test message";
    public static final String OWNER_ID = "13681297";
    public static final String ACCESS_TOKEN = "af59ce4553ab0a45a6eb0a39a8456943d25224ca576241874d4d181c7662771c4084205ce364b7147d954";

    @Test
    public void postMessageTest() throws IOException, URISyntaxException {
        RestApi restApi = new RestApi();
        int receivedStatusCode = restApi.postMessage(MESSAGE, OWNER_ID, ACCESS_TOKEN);
        int statusCode = 200;
        Assert.assertEquals(statusCode, receivedStatusCode);
    }
}