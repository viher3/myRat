package Network.Ip;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * https://hc.apache.org/httpcomponents-client-4.5.x/index.html
 */
public class PublicIpFinder implements IpFinder {
    CloseableHttpClient httpClient;
    HttpGet httpGet;

    public PublicIpFinder() {
        this.httpClient = HttpClients.createDefault();
    }

    @Override
    public String find() throws IOException {
        String ip = "";

        try{
            this.httpGet = new HttpGet("https://api.ipify.org/");

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };

            ip = this.httpClient.execute(this.httpGet, responseHandler);
        }finally{
            this.httpClient.close();
        }

        return ip;
    }
}