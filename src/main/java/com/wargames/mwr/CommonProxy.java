package com.wargames.mwr;

import cpw.mods.fml.common.event.FMLInitializationEvent;

public class CommonProxy {
    public void registerRenderers(FMLInitializationEvent event) {
        // Server does not handle rendering.
    }
}
