package com.wargames.mwr.items.armor;

import com.wargames.mwr.client.render.dummy.DummyArmorModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Base class for MWR armor items.
 * Prevents vanilla ModelBiped from rendering when overridden armor model is in use.
 */
public class ItemMWRArmor extends ItemArmor {

    public ItemMWRArmor(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
        return new DummyArmorModel(); // Prevent vanilla armor model from rendering
    }

    @SideOnly(Side.CLIENT)
    public void onArmorTick(World world, EntityLivingBase player, ItemStack itemStack) {
        // Optional hook for armor behavior
    }
}
