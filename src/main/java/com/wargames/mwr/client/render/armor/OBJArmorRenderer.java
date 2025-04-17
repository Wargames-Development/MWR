package com.wargames.mwr.client.render.armor;

import com.wargames.mwr.client.render.loader.ModelObjArmor;
import com.wargames.mwr.data.armor.ArmorGroupDefinitions;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class OBJArmorRenderer {

    private static final Map<Item, ModelObjArmor> modelRegistry = new HashMap<>();
    private static final Map<Item, ArmorGroupDefinitions> groupRegistry = new HashMap<>();

    private static final float HELMET_Y_OFFSET = -1.5F;
    private static final float JACKET_Y_OFFSET = -1.5F;
    private static final float LEFT_ARM_Y_OFFSET = -1.38F;
    private static final float LEFT_ARM_X_OFFSET = 0.31F;
    private static final float RIGHT_ARM_Y_OFFSET = -1.25F; // need to raise go +
    private static final float RIGHT_ARM_X_OFFSET = 0.02F; // need to bring into body go -
    private static final float LEFT_LEG_Y_OFFSET = -0.7F;
    private static final float RIGHT_LEG_Y_OFFSET = 0.05F;
    private static final float LEFT_LEG_X_OFFSET = 0.12F;
    private static final float RIGHT_LEG_X_OFFSET = 0.0F;
    private static final float LEG_Z_OFFSET = 0.0F;

    public static void registerArmorModel(Item item, ResourceLocation modelPath, ResourceLocation texturePath, ArmorGroupDefinitions groupDef) {
        modelRegistry.put(item, new ModelObjArmor(modelPath, texturePath));
        groupRegistry.put(item, groupDef);
    }

    @SubscribeEvent
    public void onRenderPlayer(RenderPlayerEvent.Specials.Pre event) {
        AbstractClientPlayer player = (AbstractClientPlayer) event.entityPlayer;
        ModelBiped modelBiped = event.renderer.modelBipedMain;
        ItemStack[] armor = player.inventory.armorInventory;

        for (int slot = 0; slot < armor.length; slot++) {
            ItemStack stack = armor[slot];
            if (stack == null || !(stack.getItem() instanceof ItemArmor)) continue;

            ModelObjArmor model = modelRegistry.get(stack.getItem());
            ArmorGroupDefinitions groupDef = groupRegistry.get(stack.getItem());
            if (model == null || groupDef == null) continue;

            Minecraft.getMinecraft().getTextureManager().bindTexture(model.getTexture());

            GL11.glPushMatrix();
            if (player.isSneaking()) {
                GL11.glTranslatef(0.0F, 0.2F, 0.0F);
            }

            switch (slot) {
                case 3: // Helmet
                    modelBiped.bipedHead.postRender(0.0625F); //pivot point
                    GL11.glPushMatrix();
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotatef(180F, 1F, 0F, 0F);
                    GL11.glRotatef(180F, 0F, 1F, 0F);
                    GL11.glTranslatef(0F, HELMET_Y_OFFSET, 0F);
                    model.renderOnly(groupDef.getHelmetGroups());
                    GL11.glPopMatrix();
                    break;

                case 2: // Chest + Arms
                    modelBiped.bipedBody.postRender(0.0625F);
                    GL11.glPushMatrix();
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotatef(180F, 1F, 0F, 0F);
                    GL11.glRotatef(180F, 0F, 1F, 0F);
                    GL11.glTranslatef(0F, JACKET_Y_OFFSET, 0F);
                    model.renderOnly(groupDef.getJacketGroups());
                    GL11.glPopMatrix();

                    modelBiped.bipedLeftArm.postRender(0.0625F);
                    GL11.glPushMatrix();
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotatef(180F, 1F, 0F, 0F);
                    GL11.glRotatef(180F, 0F, 1F, 0F);
                    GL11.glTranslatef(LEFT_ARM_X_OFFSET, LEFT_ARM_Y_OFFSET, 0F);
                    model.renderOnly(groupDef.getLeftArmGroups());
                    GL11.glPopMatrix();

                    modelBiped.bipedRightArm.postRender(0.0625F);
                    GL11.glPushMatrix();
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotatef(180F, 1F, 0F, 0F);
                    GL11.glRotatef(180F, 0F, 1F, 0F);
                    GL11.glTranslatef(RIGHT_ARM_X_OFFSET, RIGHT_ARM_Y_OFFSET, 0F);
                    model.renderOnly(groupDef.getRightArmGroups());
                    GL11.glPopMatrix();
                    break;

                case 0: // Legs
                    modelBiped.bipedLeftLeg.postRender(0.0625F);
                    GL11.glPushMatrix();
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotatef(180F, 1F, 0F, 0F);
                    GL11.glRotatef(180F, 0F, 1F, 0F);
                    GL11.glTranslatef(LEFT_LEG_X_OFFSET, LEFT_LEG_Y_OFFSET, LEG_Z_OFFSET);
                    model.renderOnly(groupDef.getLeftLegGroups());
                    GL11.glPopMatrix();

                    modelBiped.bipedRightLeg.postRender(0.0625F);
                    GL11.glPushMatrix();
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotatef(180F, 1F, 0F, 0F);
                    GL11.glRotatef(180F, 0F, 1F, 0F);
                    GL11.glTranslatef(RIGHT_LEG_X_OFFSET, RIGHT_LEG_Y_OFFSET, LEG_Z_OFFSET);
                    model.renderOnly(groupDef.getRightLegGroups());
                    GL11.glPopMatrix();
                    break;
            }
            GL11.glPopMatrix();
        }
    }
}