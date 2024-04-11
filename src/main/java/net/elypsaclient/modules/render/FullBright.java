package net.elypsaclient.modules.render;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;

public class FullBright extends Module {

    public FullBright() {
        super("Full Bright", "makes the dark go away", ModuleCateg.RENDER);
        setToggled(true);
    }

    @Override
    public void modAction() {
        mc.gameSettings.gammaSetting = 10000;
    }
}
