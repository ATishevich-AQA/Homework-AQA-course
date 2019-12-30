package RestApi;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class RestApiTest2 {
    public static final String MESSAGE = "test message";
    public static final String OWNER_ID = "XXXXXX";
    public static final String ACCESS_TOKEN = "NNNNNNN";
    public String post_ID = "1111";

    @Test
    public void editPostTest() throws IOException, URISyntaxException {
        RestApi restApi = new RestApi();
        int receivedStatusCode = restApi.editPost(MESSAGE, OWNER_ID, ACCESS_TOKEN, post_ID);
        int statusCode = 200;
        Assert.assertEquals(statusCode, receivedStatusCode);
    }
}