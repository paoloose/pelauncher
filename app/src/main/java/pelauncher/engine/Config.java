package pelauncher.engine;

import java.nio.file.Path;

public class Config {
    Path MINECRAFT_FOLDER = resolveHome(Path.of("~/.minecraft"));
    String MINECRAFT_VERSION = "1.20.1";
    String VERSION_URL = "https://piston-meta.mojang.com/v1/packages/cdad018fbbe4e10919b560da3d1640d7b6355dbf/1.20.1.json";

    private static Path resolveHome(Path path) {
        if (path.toString().startsWith("~/")) {
            return Path.of(System.getProperty("user.home")).resolve(path.toString().substring(2));
        }
        else if (path.toString().equals("~")) {
            return Path.of(System.getProperty("user.home"));
        }
        return path;
    }
}
