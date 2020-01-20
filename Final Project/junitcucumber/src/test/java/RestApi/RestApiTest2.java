package RestApi;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class RestApiTest2 {
    public static final String MESSAGE = "test message has been updated";
    public static final String OWNER_ID = "13681297";
    public static final String ACCESS_TOKEN = "af59ce4553ab0a45a6eb0a39a8456943d25224ca576241874d4d181c7662771c4084205ce364b7147d954";
    public String post_ID = "3228";

    @Test
    public void editPostTest() throws IOException, URISyntaxException {
        RestApi restApi = new RestApi();
        int receivedStatusCode = restApi.editPost(MESSAGE, OWNER_ID, ACCESS_TOKEN, post_ID);
        int statusCode = 200;
        Assert.assertEquals(statusCode, receivedStatusCode);
    }
}