package com.wargames.mwr.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class DebugConfig {
    private final Configuration config;

    public boolean ENABLE_DEBUG;
    public boolean ENABLE_LOAD_LOGS;
    public boolean ENABLE_TESTS;

    public DebugConfig(File file) {
        this.config = new Configuration(file);
        load();
    }

    public void load() {
        config.load();

        ENABLE_DEBUG = config.get("general", "enable_debug_logging", true, "Enable general debug logging across the mod.").getBoolean();
        ENABLE_LOAD_LOGS = config.get("general", "enable_startup_logging", true, "Log mod loading lifecycle events: preInit, init, postInit, etc.").getBoolean();
        ENABLE_TESTS = config.get("general", "enable_test_suite", true, "Run built-in test suite on startup to verify internal mod functionality.").getBoolean();

        if (config.hasChanged()) config.save();
    }

    public File getFile() {
        return config.getConfigFile();
    }

    public void reset() {
        File f = config.getConfigFile();
        if (f.exists()) f.delete();
        load();
    }
}