package pelauncher.utils.net;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class HTTPJSONRequest {
    public static <T> T GET(String url, Class<T> classOf) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(url))
            .GET()
            .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();

        T json = gson.fromJson(response.body(), classOf);
        return json;
    }
}
