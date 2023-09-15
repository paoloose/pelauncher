package pelauncher;

import java.io.IOException;

import pelauncher.engine.Config;
import pelauncher.engine.Launcher;

public class App {
    public static void main(String[] args) {
        Config config = new Config();
        Launcher launcher = new Launcher(config);

        try {
            launcher.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
