package Network.Ip;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * https://hc.apache.org/httpcomponents-client-5.1.x/examples.html
 */
public class PublicIpFinder implements IpFinder {
    CloseableHttpClient httpClient;
    HttpGet httpGet;

    public PublicIpFinder() {
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet("https://api.ipify.org/");
    }

    @Override
    public String find() {
        //CloseableHttpResponse response1 = this.httpClient.execute(this.httpGet, responseHandler);

        return "";
    }
}