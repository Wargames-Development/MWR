package com.wargames.mwr.command;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;

public class MWRCommandHandler {
    public static void registerCommands(FMLServerStartingEvent event) {
        ICommandManager commandManager = event.getServer().getCommandManager();
        if (commandManager instanceof ServerCommandManager) {
            ((ServerCommandManager) commandManager).registerCommand(new MWRCommand());
        }
    }
}