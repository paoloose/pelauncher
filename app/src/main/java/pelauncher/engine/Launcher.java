package pelauncher.engine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Launcher {
    private final Config config;

    public Launcher(Config config) {
        this.config = config;
    }

    public void start() throws IOException {
        this.prelude();
        this.launchProcess();
    }

    private void prelude() throws IOException {
        Bootstrapper bootstrapper = new Bootstrapper(config, true);
        bootstrapper.start();
    }

    private void launchProcess() throws IOException {
        String mainClass = "net.minecraft.client.main.Main";
        String[] gameArgs = new String[] {
            "--version", config.MINECRAFT_VERSION,
            "--gameDir", config.MINECRAFT_FOLDER.toString(),
            "--accessToken", "dummy",
        };

        String librariesJars = Files.list(config.MINECRAFT_FOLDER.resolve("libraries")).map(lib -> lib.toString()).reduce((a, b) -> a + ":" + b).get();
        String clientJar = config.MINECRAFT_FOLDER.resolve("versions").resolve(config.MINECRAFT_VERSION).resolve(config.MINECRAFT_VERSION + ".jar").toString();

        String cmd = "java -cp " + librariesJars + File.pathSeparator + clientJar + " " + mainClass + " " + String.join(" ", gameArgs);
        var process = new ProcessBuilder(cmd.split(" "))
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start();

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
