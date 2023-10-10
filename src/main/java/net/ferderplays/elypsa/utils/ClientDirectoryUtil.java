package net.ferderplays.elypsa.utils;

import net.elypsaclient.utils.FileUtil;

import java.io.File;

public class ClientDirectoryUtil {
    public static void init() {
        makeDir(FileUtil.getClientDir());
        makeDir(FileUtil.getClientConfigDir());
    }

    private static void makeDir(String dir) {
        FileUtil.createDir(dir);
    }
}
