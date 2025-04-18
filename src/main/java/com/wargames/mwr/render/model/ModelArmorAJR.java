//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wargames.mwr.render.model;

import com.hbm.render.model.ModelArmorBase;
import com.hbm.main.ResourceManager;
import com.hbm.render.loader.ModelRendererObj;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelArmorAJR extends ModelArmorBase {
    public ModelArmorAJR(int type) {
        super(type);
        this.head = new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"Head"});
        this.body = new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"Body"});
        this.leftArm = (new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"LeftArm"})).setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.rightArm = (new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"RightArm"})).setRotationPoint(5.0F, 2.0F, 0.0F);
        this.leftLeg = (new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"LeftLeg"})).setRotationPoint(1.9F, 12.0F, 0.0F);
        this.rightLeg = (new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"RightLeg"})).setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.leftFoot = (new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"LeftBoot"})).setRotationPoint(1.9F, 12.0F, 0.0F);
        this.rightFoot = (new ModelRendererObj(ResourceManager.armor_ajr, new String[]{"RightBoot"})).setRotationPoint(-1.9F, 12.0F, 0.0F);
    }

    public void func_78088_a(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        GL11.glPushMatrix();
        GL11.glShadeModel(7425);
        if (this.type == 0) {
            bindTexture(ResourceManager.ajr_helmet);
            this.head.render(scaleFactor);
        }

        if (this.type == 1) {
            bindTexture(ResourceManager.ajr_chest);
            this.body.render(scaleFactor);
            bindTexture(ResourceManager.ajr_arm);
            this.leftArm.render(scaleFactor);
            this.rightArm.render(scaleFactor);
        }

        if (this.type == 2) {
            bindTexture(ResourceManager.ajr_leg);
            this.leftLeg.render(scaleFactor);
            this.rightLeg.render(scaleFactor);
        }

        if (this.type == 3) {
            bindTexture(ResourceManager.ajr_leg);
            this.leftFoot.render(scaleFactor);
            this.rightFoot.render(scaleFactor);
        }

        GL11.glShadeModel(7424);
        GL11.glPopMatrix();
    }
}
