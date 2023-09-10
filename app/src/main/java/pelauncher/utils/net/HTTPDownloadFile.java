package pelauncher.utils.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HTTPDownloadFile {
    public static void download(String url, Path path) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(url))
            .GET()
            .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<InputStream> stream = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        FileOutputStream outputStream = new FileOutputStream(path.toFile());
        stream.body().transferTo(outputStream);
        outputStream.close();
    }
}
