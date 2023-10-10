package net.ferderplays.elypsa.utils;

import net.elypsaclient.client.Main;
import net.elypsaclient.modules.Module;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ConfigUtil {
    public static void loadConfig(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String lines = "";
            String line;
            while ((line = br.readLine()) != null) {
                lines += line + "\n";
            }
        } catch (IOException exception) {
            Main.logger.info(exception.getStackTrace());
        }
    }

    public static void saveConfig(String path, Module module) {

    }
}
