package com.wargames.mwr.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandConfig {
    public static final String FILE_NAME = "commands.cfg";
    private final Configuration config;

    private final Map<String, CommandEntry> commands = new LinkedHashMap<String, CommandEntry>();

    public CommandConfig(File file) {
        this.config = new Configuration(file);
        load();
    }

    public void load() {
        commands.clear();
        config.load();

        addCommand("help", "player", true, "mwr.help", "Provides a list of available commands");
        addCommand("reload", "debugging", true, "mwr.reload", "Reloads all configuration files");
        addCommand("reset", "debugging", true, "mwr.reset", "Resets one or more configuration files");

        if (config.hasChanged()) config.save();
    }

    private void addCommand(String name, String category, boolean defaultEnabled, String permission, String comment) {
        boolean enabled = config.get(category, "enable_" + name + "_command", defaultEnabled, comment + " | Permission node: " + permission).getBoolean();
        commands.put(name, new CommandEntry(category, enabled, permission, comment));
    }

    public void reset() {
        File f = config.getConfigFile();
        if (f.exists()) f.delete();
        load();
    }

    public Map<String, CommandEntry> getCommands() {
        return commands;
    }

    public File getFile() {
        return config.getConfigFile();
    }

    public static class CommandEntry {
        public final String category;
        public final boolean enabled;
        public final String permissionNode;
        public final String description;

        public CommandEntry(String category, boolean enabled, String permissionNode, String description) {
            this.category = category;
            this.enabled = enabled;
            this.permissionNode = permissionNode;
            this.description = description;
        }
    }
}