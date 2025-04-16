package com.wargames.mwr.client.render.loader;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Set;

/**
 * A wrapper around WavefrontObject to support armor rendering.
 * Adapted from HBM's ModelObjArmor. Attribution under GNU GPLv3.
 */
public class ModelObjArmor extends ModelBase {

    private final WavefrontObject model;
    private final ResourceLocation texture;

    public ModelObjArmor(ResourceLocation obj, ResourceLocation tex) {
        this.model = new WavefrontObject(obj);
        this.texture = tex;
    }

    /**
     * Renders only the specified groups. All transforms should be handled externally.
     */
    public void renderOnly(Set<String> groups) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);
        model.renderGroups(groups);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public WavefrontObject getWavefrontObject() {
        return model;
    }
}