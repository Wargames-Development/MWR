package com.wargames.mwr;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Defines all creative tabs for the MWR mod.
 */
public class MWRCreativeTabs {

    public static final CreativeTabs tabArmor = new CreativeTabs("mwrArmor") {
        @Override
        public Item getTabIconItem() {
            return Items.iron_chestplate; // Temporary icon
        }
    };
}
