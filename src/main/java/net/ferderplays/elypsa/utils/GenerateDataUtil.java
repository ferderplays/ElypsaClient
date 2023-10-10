package net.ferderplays.elypsa.utils;

import net.elypsaclient.modules.Module;

import java.util.ArrayList;
import java.util.HashMap;

public class GenerateDataUtil {
    public static HashMap genData(Module module) {
        HashMap data = new HashMap();
        data.put("keybind", module.keyChar);
        return data;
    }

    public static HashMap regenData(Module module) {
        return genData(module);
    }
}
