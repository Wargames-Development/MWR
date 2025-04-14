package com.wargames.mwr.configuration;

import java.io.File;

public class ConfigHandler {

    private final DebugConfig debugConfig;
    private final CommandConfig commandConfig;

    public ConfigHandler(File configDir) {
        if (!configDir.exists()) configDir.mkdirs();

        this.debugConfig = new DebugConfig(new File(configDir, "debugging.cfg"));
        this.commandConfig = new CommandConfig(new File(configDir, "commands.cfg"));
    }

    public void reloadAll() {
        debugConfig.load();
        commandConfig.load();
    }

    public void resetAll() {
        debugConfig.reset();
        commandConfig.reset();
    }

    public DebugConfig getDebugConfig() {
        return debugConfig;
    }

    public CommandConfig getCommandConfig() {
        return commandConfig;
    }
}