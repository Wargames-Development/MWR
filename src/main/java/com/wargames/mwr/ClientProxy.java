package com.wargames.mwr;

import com.wargames.mwr.client.render.armor.OBJArmorRenderer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new OBJArmorRenderer());
    }
}
