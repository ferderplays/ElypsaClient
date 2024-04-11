package net.elypsaclient.utils;

import net.elypsaclient.client.Main;

import java.io.File;
import java.io.IOException;

public class FileUtil extends Util {

    private static String getHomeDir() {
        return prop("user.home");
    }

    private static String getOsName() {
        return prop("os.name").toLowerCase();
    }

    private static String prop(String name) {
        return System.getProperty(name);
    }
    private static String getMcDir() {
        String mcdir = "";
        String osname = getOsName();
        if (osname.startsWith("windows")) {
            mcdir = getHomeDir() + "/appdata/roaming/.minecraft";
        } else if (osname.startsWith("linux")) {
            mcdir = getHomeDir() + "/.config/.minecraft";
        }
        return mcdir;
    }

    public static String getClientDir() {
        return getMcDir() + "/elypsa";
    }

    public static String getClientConfigDir() {
        return getClientDir() + "/configs";
    }

    public static void createDir(String path) {
        File dir = new File(path);
        if (dir.exists()) return;
        else dir.mkdir();
    }

    public static void createFile(String path, String filename) {
        File file = new File(path + "/" + filename);
        if (file.isFile()) return;
        else {
            try {
                file.createNewFile();
            } catch (Exception e) {
                Main.logger.error("Unable to make file");
            }
        }
    }
}
