package com.wargames.mwr.items.armor;

import com.wargames.mwr.render.model.ModelArmorMarine;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMWRMarineArmor extends ItemArmor {

    public ItemMWRMarineArmor(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        this.setUnlocalizedName("marineArmor" + armorType);
        this.setTextureName("mwr:marine_armor_" + armorType);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getArmorModel(net.minecraft.entity.EntityLivingBase entity, ItemStack itemStack, int armorSlot) {
        return new ModelArmorMarine(armorSlot);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        //return "mwr:textures/armor/usmc.png";
        return null;
    }
}
