package pelauncher.engine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import pelauncher.schemas.MinecraftVersionResponse.Library;
import pelauncher.schemas.MinecraftVersionResponse.MinecraftVersion;
import pelauncher.utils.Platform;
import pelauncher.utils.net.HTTPDownloadFile;
import pelauncher.utils.net.HTTPJSONRequest;

public class Bootstrapper {
    private final boolean strict;
    private final Config config;
    private final Path gameDir;
    private final Path libsDir;

    public Bootstrapper(Config config, boolean strict) {
        this.config = config;
        this.gameDir = config.MINECRAFT_FOLDER;
        this.libsDir = gameDir.resolve("libraries");
        this.strict = strict;
    }

    public void start() throws IOException {
        this.prelude();
        if (Files.list(libsDir).count() == 0 || this.strict) {
            this.downloadJars(gameDir.resolve("libraries"));
        }
    }

    private void prelude() throws RuntimeException {
        try {
            createIfNotExists(this.gameDir);
            createIfNotExists(this.gameDir.resolve("versions"));
            createIfNotExists(this.gameDir.resolve("libraries"));
            createIfNotExists(this.gameDir.resolve("assets"));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createIfNotExists(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
            System.out.println("Creating directory: " + path.toString());
        }
    }

    /**
     * Downloads the jars from the specific config.VERSION_URL
     * @param libPath
     */
    private void downloadJars(Path libPath) {
        try {
            // TODO: move this to a cache
            MinecraftVersion version = HTTPJSONRequest.GET(this.config.VERSION_URL, MinecraftVersion.class);
            String osname = Platform.getOSName();

            for (Library lib : version.libraries) {
                if (lib.rules != null && !lib.rules.get(0).os.name.equals(osname)) {
                    continue;
                }
                String libname = Path.of(lib.downloads.artifact.path).getFileName().toString();
                Path libpath = libPath.resolve(libname);

                if (!Files.exists(libpath)) {
                    HTTPDownloadFile.download(lib.downloads.artifact.url, libpath);
                    System.out.println(libname);
                }
            }

            String clientJarURL = version.downloads.client.url;
            Path clientPath = this.gameDir.resolve("versions").resolve(version.id).resolve(version.id + ".jar");
            Files.createDirectories(clientPath.getParent());
            HTTPDownloadFile.download(clientJarURL, clientPath);
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
