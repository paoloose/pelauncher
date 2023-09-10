package pelauncher.utils;

public final class Platform {
    public enum OS {
        LINUX,
        MAC,
        WINDOWS
    }
    static OS os;

    public static OS getOS() {
        if (os != null) {
            return os;
        }
        String osname = System.getProperty("os.name");

        if ((osname.contains("nix") || osname.contains("nux")|| osname.contains("aix"))) {
            os = OS.LINUX;
        }
        else if (osname.contains("win")) {
            os = OS.WINDOWS;
        }
        else if (osname.contains("mac")) {
            os = OS.MAC;
        }
        else {
            throw new RuntimeException("Unsupported Operating System: " + osname);
        }

        return os;
    }

    public static String getOSName() {
        return switch (getOS()) {
            case LINUX -> "linux";
            case MAC -> "osx";
            case WINDOWS -> "windows";
        };
    }
}
