package com.wargames.mwr.test;

import com.wargames.mwr.test.impl.BackpackFunctionalityTest;
import com.wargames.mwr.test.impl.ItemRegistrationTest;
import com.wargames.mwr.test.impl.NBTSerializationTest;
import com.wargames.mwr.test.impl.CommandTest;
import com.wargames.mwr.test.impl.ConfigTest;

public class TestSuite {

    public static void runPreInitTests() {
        ItemRegistrationTest.run();
        CommandTest.run();
        ConfigTest.run();
    }

    public static void runInitTests() {
        // Placeholder for mid-initialization tests
    }

    public static void runPostInitTests() {
        NBTSerializationTest.run();
        BackpackFunctionalityTest.run();
    }
}