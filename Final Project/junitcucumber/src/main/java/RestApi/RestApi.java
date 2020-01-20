package RestApi;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.URISyntaxException;


public class RestApi {

    Logger log = Logger.getLogger(RestApi.class.getName());

    public int postMessage(String MESSAGE, String OWNER_ID, String ACCESS_TOKEN) throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
        builder.setParameter("access_token", ACCESS_TOKEN)
                .setParameter("owner_id", OWNER_ID)
                .setParameter("message", MESSAGE)
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
        String stringMessage = "Post message was executed";
        log.error(stringMessage);
        return response.getStatusLine().getStatusCode();
    }

    public int editPost(String MESSAGE, String OWNER_ID, String ACCESS_TOKEN, String post_ID) throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.edit?");
        builder.setParameter("access_token", ACCESS_TOKEN)
                .setParameter("owner_id", OWNER_ID)
                .setParameter("post_id", post_ID)
                .setParameter("message", MESSAGE)
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
        String stringMessage = "Edit message was executed";
        log.error(stringMessage);
        return response.getStatusLine().getStatusCode();
    }

    public int deletePost(String ACCESS_TOKEN, String OWNER_ID, String post_ID) throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.delete?");
        builder.setParameter("access_token", ACCESS_TOKEN)
                .setParameter("owner_id", OWNER_ID)
                .setParameter("post_id", post_ID)
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
        String stringMessage = "Delete message was executed";
        log.info(stringMessage);
        return response.getStatusLine().getStatusCode();
    }
}