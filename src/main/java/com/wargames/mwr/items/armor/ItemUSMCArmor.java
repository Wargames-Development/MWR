package com.wargames.mwr.items.armor;

import com.wargames.mwr.MWRCreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ItemUSMCArmor {

    public static Item usmcHelmet;
    public static Item usmcChest;
    // public static Item usmcLegs;
    public static Item usmcBoots;

    public static void init() {
        ItemArmor.ArmorMaterial usmcMaterial = ItemArmor.ArmorMaterial.IRON;

        usmcHelmet = new ItemMWRArmor(usmcMaterial, 0, 0)
                .setUnlocalizedName("usmc_helmet")
                .setCreativeTab(MWRCreativeTabs.tabArmor);

        usmcChest = new ItemMWRArmor(usmcMaterial, 0, 1)
                .setUnlocalizedName("usmc_chestplate")
                .setCreativeTab(MWRCreativeTabs.tabArmor);

        // usmcLegs = new ItemMWRArmor(usmcMaterial, 0, 2)
        //         .setUnlocalizedName("usmc_leggings")
        //         .setCreativeTab(MWRCreativeTabs.tabArmor);

        usmcBoots = new ItemMWRArmor(usmcMaterial, 0, 3)
                .setUnlocalizedName("usmc_boots")
                .setCreativeTab(MWRCreativeTabs.tabArmor);
    }
}