package com.wargames.mwr.command;

import com.wargames.mwr.MWRMod;
import com.wargames.mwr.configuration.CommandConfig;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.event.HoverEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MWRCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "mwr";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/mwr <reload|reset|help> [config]";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        CommandConfig commandCfg = MWRMod.CONFIGS.getCommandConfig();

        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            if (!commandCfg.getCommands().get("help").enabled) {
                sender.addChatMessage(new ChatComponentText("§c[MWR] /mwr help is disabled."));
                return;
            }
            sender.addChatMessage(new ChatComponentText("§6[MWR] §fAvailable Commands:"));
            for (String key : commandCfg.getCommands().keySet()) {
                CommandConfig.CommandEntry entry = commandCfg.getCommands().get(key);
                if (entry.enabled) {
                    IChatComponent line = new ChatComponentText("§e/mwr " + key + " §7- " + entry.description);
                    ChatStyle style = new ChatStyle();
                    style.setColor(EnumChatFormatting.GRAY);
                    style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                            new ChatComponentText("Permission node: " + entry.permissionNode)));
                    line.setChatStyle(style);
                    sender.addChatMessage(line);
                }
            }
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!commandCfg.getCommands().get("reload").enabled) {
                sender.addChatMessage(new ChatComponentText("§c[MWR] /mwr reload is disabled."));
                return;
            }
            if (!sender.canCommandSenderUseCommand(2, "mwr.reload")) {
                sender.addChatMessage(new ChatComponentText("§c[MWR] You do not have permission to use /mwr reload"));
                return;
            }
            MWRMod.CONFIGS.reloadAll();
            sender.addChatMessage(new ChatComponentText("§a[MWR] All configurations reloaded."));
            return;
        }

        if (args[0].equalsIgnoreCase("reset")) {
            if (!commandCfg.getCommands().get("reset").enabled) {
                sender.addChatMessage(new ChatComponentText("§c[MWR] /mwr reset is disabled."));
                return;
            }
            if (!sender.canCommandSenderUseCommand(2, "mwr.reset")) {
                sender.addChatMessage(new ChatComponentText("§c[MWR] You do not have permission to use /mwr reset"));
                return;
            }

            if (args.length == 2) {
                String config = args[1];
                if (config.equalsIgnoreCase("debugging")) {
                    MWRMod.CONFIGS.getDebugConfig().reset();
                    sender.addChatMessage(new ChatComponentText("§a[MWR] Reset debugging configuration."));
                } else if (config.equalsIgnoreCase("commands")) {
                    MWRMod.CONFIGS.getCommandConfig().reset();
                    sender.addChatMessage(new ChatComponentText("§a[MWR] Reset command configuration."));
                } else {
                    sender.addChatMessage(new ChatComponentText("§c[MWR] Unknown config: " + config));
                }
            } else {
                MWRMod.CONFIGS.resetAll();
                sender.addChatMessage(new ChatComponentText("§a[MWR] All configurations have been reset to defaults."));
            }
            return;
        }

        sender.addChatMessage(new ChatComponentText("§c[MWR] Unknown command. Use /mwr help."));
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("mwrcmd");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args, new String[] { "reload", "reset", "help" });
        } else if (args.length == 2 && args[0].equalsIgnoreCase("reset")) {
            File configDir = MWRMod.CONFIGS.getDebugConfig().getFile().getParentFile();
            File[] files = configDir.listFiles();
            List<String> names = new ArrayList<String>();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().endsWith(".cfg")) {
                        names.add(f.getName().replace(".cfg", ""));
                    }
                }
            }
            return getListOfStringsMatchingLastWord(args, names.toArray(new String[0]));
        }
        return Collections.emptyList();
    }
}
