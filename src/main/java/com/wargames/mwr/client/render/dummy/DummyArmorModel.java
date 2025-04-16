package com.wargames.mwr.client.render.dummy;

import net.minecraft.client.model.ModelBiped;

/**
 * A blank armor model that prevents vanilla rendering.
 */
public class DummyArmorModel extends ModelBiped {
    public DummyArmorModel() {
        bipedHead.showModel = false;
        bipedBody.showModel = false;
        bipedRightArm.showModel = false;
        bipedLeftArm.showModel = false;
        bipedRightLeg.showModel = false;
        bipedLeftLeg.showModel = false;
    }
}
