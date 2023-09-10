package mlauncher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import mlauncher.schemas.MinecraftVersionResponse.Library;
import mlauncher.schemas.MinecraftVersionResponse.MinecraftVersion;
import mlauncher.schemas.VersionsManifestResponse.VersionsManifest;
import mlauncher.utils.Platform;
import mlauncher.utils.net.HTTPDownloadFile;
import mlauncher.utils.net.HTTPJSONRequest;

public class App {
    static final String VERSIONS_MANIFEST_URL = "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json";
    static final String VERSION_1_20_2 = "https://piston-meta.mojang.com/v1/packages/cc76565cb70891f5d3721191b9e00c3e384332fb/1.20.2-pre2.json";

    public static void main(String[] args) {
        try {
            HTTPJSONRequest.GET(VERSIONS_MANIFEST_URL, VersionsManifest.class);
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            MinecraftVersion version = HTTPJSONRequest.GET(VERSION_1_20_2, MinecraftVersion.class);
            String osname = Platform.getOSName();

            Path jarsOutput = Path.of("../bin");
            if (!Files.exists(jarsOutput)) {
                Files.createDirectory(jarsOutput);
            }

            for (Library lib : version.libraries) {
                if (lib.rules != null && lib.rules.stream().allMatch(rule -> !rule.os.name.equals(osname))) {
                    continue;
                }
                String libname = Path.of(lib.downloads.artifact.path).getFileName().toString();
                HTTPDownloadFile.download(
                    lib.downloads.artifact.url,
                    jarsOutput.resolve(libname)
                );
                System.out.println(libname);
            }

            String clientJARURL = version.downloads.client.url;
            Path pathToSave = Path.of("..", "client.jar");
            Files.createDirectories(pathToSave.getParent());
            HTTPDownloadFile.download(clientJARURL, pathToSave);
        }
        catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
