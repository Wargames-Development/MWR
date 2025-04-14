package com.wargames.mwr.test.impl;

import com.wargames.mwr.MWRMod;
import com.wargames.mwr.configuration.CommandConfig;
import com.wargames.mwr.configuration.DebugConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConfigTest {

    public static void run() {
        System.out.println("[MWR TEST] Running ConfigTest...");

        List<File> configs = new ArrayList<File>();
        configs.add(MWRMod.CONFIGS.getDebugConfig().getFile());
        configs.add(MWRMod.CONFIGS.getCommandConfig().getFile());

        boolean allPresent = true;

        for (File config : configs) {
            if (!config.exists()) {
                System.err.println("[MWR TEST] Missing config file: " + config.getName());
                allPresent = false;
                continue;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(config))) {
                boolean hasComments = false;
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().startsWith("#")) {
                        hasComments = true;
                        break;
                    }
                }
                if (!hasComments) {
                    System.err.println("[MWR TEST] Config missing inline comments: " + config.getName());
                    allPresent = false;
                }
            } catch (Exception e) {
                System.err.println("[MWR TEST] Error reading config: " + config.getName());
                allPresent = false;
            }
        }

        if (allPresent) {
            System.out.println("[MWR TEST] ConfigTest passed. All configs present and documented.");
        } else {
            System.err.println("[MWR TEST] ConfigTest failed. See errors above.");
        }
    }
}