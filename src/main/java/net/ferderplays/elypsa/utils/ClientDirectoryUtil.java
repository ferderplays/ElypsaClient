package net.ferderplays.elypsa.utils;

import net.elypsaclient.client.Main;
import net.elypsaclient.modules.Module;
import net.elypsaclient.utils.FileUtil;

import java.io.File;

public class ClientDirectoryUtil {
    public static void init() {
        makeDir(FileUtil.getClientDir());
        makeDir(FileUtil.getClientConfigDir());
        for (Module module : Main.moduleManager.modules) {
            makeConfigFile(module);
        }
    }

    private static void makeConfigFile(Module module) {
        String name = module.getName();
        makeJSONFile(FileUtil.getClientConfigDir(), name);
    }

    private static void makeDir(String dir) {
        FileUtil.createDir(dir);
    }

    private static void makeJSONFile(String path, String filename) {
        FileUtil.createFile(path, filename);
    }
}
