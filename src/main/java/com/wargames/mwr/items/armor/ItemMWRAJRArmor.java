package com.wargames.mwr.items.armor;

import com.hbm.render.model.ModelArmorAJR;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMWRAJRArmor extends ItemArmor {

    public ItemMWRAJRArmor(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        this.setUnlocalizedName("ajrArmor" + armorType);
        this.setTextureName("mwr:ajr_armor_" + armorType);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getArmorModel(net.minecraft.entity.EntityLivingBase entity, ItemStack itemStack, int armorSlot) {
        return new ModelArmorAJR(armorSlot);
    }
}