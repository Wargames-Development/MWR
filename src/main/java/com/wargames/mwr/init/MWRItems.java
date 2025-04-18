package com.wargames.mwr.init;

import com.wargames.mwr.items.armor.ItemMWRAJRArmor;
import com.wargames.mwr.items.armor.ItemMWRMarineArmor;
import com.wargames.mwr.MWRCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class MWRItems {

    public static Item ajrHelmet;
    public static Item ajrChestplate;
    public static Item ajrLeggings;
    public static Item ajrBoots;

    public static Item marineHelmet;
    public static Item marineChestplate;
    public static Item marineLeggings;
    public static Item marineBoots;

    public static void init() {
//        ItemArmor.ArmorMaterial ajrMaterial = EnumHelper.addArmorMaterial("AJR", 33, new int[]{3, 8, 6, 3}, 10);
        ItemArmor.ArmorMaterial marineMaterial = EnumHelper.addArmorMaterial("MARINE", 30, new int[]{3, 7, 5, 2}, 9);

//        ajrHelmet = new ItemMWRAJRArmor(ajrMaterial, 0, 0).setCreativeTab(MWRCreativeTabs.tabArmor);
//        ajrChestplate = new ItemMWRAJRArmor(ajrMaterial, 0, 1).setCreativeTab(MWRCreativeTabs.tabArmor);
//        ajrLeggings = new ItemMWRAJRArmor(ajrMaterial, 0, 2).setCreativeTab(MWRCreativeTabs.tabArmor);
//        ajrBoots = new ItemMWRAJRArmor(ajrMaterial, 0, 3).setCreativeTab(MWRCreativeTabs.tabArmor);

        marineHelmet = new ItemMWRMarineArmor(marineMaterial, 0, 0).setCreativeTab(MWRCreativeTabs.tabArmor);
        marineChestplate = new ItemMWRMarineArmor(marineMaterial, 0, 1).setCreativeTab(MWRCreativeTabs.tabArmor);
//        marineLeggings = new ItemMWRMarineArmor(marineMaterial, 0, 2).setCreativeTab(MWRCreativeTabs.tabArmor);
        marineBoots = new ItemMWRMarineArmor(marineMaterial, 0, 3).setCreativeTab(MWRCreativeTabs.tabArmor);

//        GameRegistry.registerItem(ajrHelmet, "ajrHelmet");
//        GameRegistry.registerItem(ajrChestplate, "ajrChestplate");
//        GameRegistry.registerItem(ajrLeggings, "ajrLeggings");
//        GameRegistry.registerItem(ajrBoots, "ajrBoots");

        GameRegistry.registerItem(marineHelmet, "marineHelmet");
        GameRegistry.registerItem(marineChestplate, "marineChestplate");
//        GameRegistry.registerItem(marineLeggings, "marineLeggings");
        GameRegistry.registerItem(marineBoots, "marineBoots");
    }
}