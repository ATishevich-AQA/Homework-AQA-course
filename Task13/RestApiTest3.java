package RestApi;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class RestApiTest3 {
    public static final String OWNER_ID = "XXXXXX";
    public static final String ACCESS_TOKEN = "NNNNNNNN";
    public String post_ID = "11111";

    @Test
    public void deletePostTest() throws IOException, URISyntaxException {
        RestApi restApi = new RestApi();
        int receivedStatusCode = restApi.deletePost(ACCESS_TOKEN, OWNER_ID, post_ID);
        int statusCode = 200;
        Assert.assertEquals(statusCode, receivedStatusCode);
    }
}