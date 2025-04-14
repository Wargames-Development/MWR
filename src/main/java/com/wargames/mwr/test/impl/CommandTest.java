package com.wargames.mwr.test.impl;

import com.wargames.mwr.MWRMod;
import com.wargames.mwr.configuration.CommandConfig;

public class CommandTest {

    public static void run() {
        System.out.println("[MWR TEST] Running CommandTest...");

        CommandConfig config = MWRMod.CONFIGS.getCommandConfig();

        boolean allValid = true;

        for (String name : config.getCommands().keySet()) {
            CommandConfig.CommandEntry entry = config.getCommands().get(name);

            if (entry.permissionNode == null || entry.permissionNode.trim().isEmpty()) {
                System.err.println("[MWR TEST] Command '" + name + "' is missing a permission node!");
                allValid = false;
            }

            if (entry.description == null || entry.description.trim().isEmpty()) {
                System.err.println("[MWR TEST] Command '" + name + "' is missing a description!");
                allValid = false;
            }
        }

        if (allValid) {
            System.out.println("[MWR TEST] CommandTest passed. All commands are valid.");
        } else {
            System.err.println("[MWR TEST] CommandTest failed. See errors above.");
        }
    }
}