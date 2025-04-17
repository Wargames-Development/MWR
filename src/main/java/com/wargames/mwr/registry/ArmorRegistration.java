package com.wargames.mwr.registry;

import com.wargames.mwr.client.render.armor.OBJArmorRenderer;
import com.wargames.mwr.data.armor.MarineOBJGroups;
import com.wargames.mwr.items.armor.ItemUSMCArmor;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ArmorRegistration {

    public static void register() {
        ItemUSMCArmor.init();

        GameRegistry.registerItem(ItemUSMCArmor.usmcHelmet, "usmc_helmet");
        GameRegistry.registerItem(ItemUSMCArmor.usmcChest, "usmc_chestplate");
        GameRegistry.registerItem(ItemUSMCArmor.usmcBoots, "usmc_boots");

        OBJArmorRenderer.registerArmorModel(
                ItemUSMCArmor.usmcChest,
                new ResourceLocation("mwr", "models/armor/marine3.obj"),
                new ResourceLocation("mwr", "textures/armor/usmc.png"),
                new MarineOBJGroups()
        );

        OBJArmorRenderer.registerArmorModel(
                ItemUSMCArmor.usmcHelmet,
                new ResourceLocation("mwr", "models/armor/marine3.obj"),
                new ResourceLocation("mwr", "textures/armor/usmc.png"),
                new MarineOBJGroups()
        );

        OBJArmorRenderer.registerArmorModel(
                ItemUSMCArmor.usmcBoots,
                new ResourceLocation("mwr", "models/armor/marine3.obj"),
                new ResourceLocation("mwr", "textures/armor/usmc.png"),
                new MarineOBJGroups()
        );
    }
}