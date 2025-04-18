package com.wargames.mwr.util;

import com.hbm.render.loader.HFRWavefrontObject;
import net.minecraft.util.ResourceLocation;

public class ResourceManager {

    // Wavefront OBJ model for the marine armor
    public static final HFRWavefrontObject armor_marine = new HFRWavefrontObject(
            new ResourceLocation("mwr", "models/armor/marine.obj")
    );

    // Texture associated with the marine armor model
    public static final ResourceLocation armor_marine_texture = new ResourceLocation(
            "mwr", "textures/armor/usmc.png"
    );

    // Add additional model/texture pairs below as needed.
}
