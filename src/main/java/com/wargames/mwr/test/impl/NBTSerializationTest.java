package com.wargames.mwr.test.impl;

import net.minecraft.nbt.NBTTagCompound;

public class NBTSerializationTest {

    public static void run() {
        System.out.println("[MWR TEST] Running NBTSerializationTest...");

        try {
            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("testKey", "testValue");

            if (!"testValue".equals(tag.getString("testKey"))) {
                throw new Exception("NBT read/write failed");
            }

            System.out.println("[MWR TEST] NBTSerializationTest passed.");
        } catch (Exception e) {
            System.err.println("[MWR TEST] NBTSerializationTest failed: " + e.getMessage());
        }
    }
}