package com.wargames.mwr;

import com.wargames.mwr.command.MWRCommandHandler;
import com.wargames.mwr.configuration.ConfigHandler;
import com.wargames.mwr.registry.ArmorRegistration;
import com.wargames.mwr.test.TestSuite;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = MWRMod.MODID, name = MWRMod.NAME, version = MWRMod.VERSION)
public class MWRMod {
    public static final String MODID = "mwr";
    public static final String NAME = "Modern Warfare Reborn";
    public static final String VERSION = "1.0";
    public static final Logger LOGGER = LogManager.getLogger("MWR");

    public static ConfigHandler CONFIGS;

    @SidedProxy(clientSide = "com.wargames.mwr.ClientProxy", serverSide = "com.wargames.mwr.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File configDir = new File(event.getModConfigurationDirectory(), "MWR");
        CONFIGS = new ConfigHandler(configDir);

        ArmorRegistration.register(); // Register all armor items

        if (CONFIGS.getDebugConfig().ENABLE_LOAD_LOGS) LOGGER.info("[MWR] Pre-initialization started.");
        if (CONFIGS.getDebugConfig().ENABLE_TESTS) {
            try {
                TestSuite.runPreInitTests();
            } catch (Throwable t) {
                LOGGER.error("[MWR] Error running PreInit tests", t);
            }
        }
        if (CONFIGS.getDebugConfig().ENABLE_LOAD_LOGS) LOGGER.info("[MWR] Pre-initialization completed.");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        if (CONFIGS.getDebugConfig().ENABLE_LOAD_LOGS) LOGGER.info("[MWR] Initialization started.");

        // Register client-side render hooks
        proxy.registerRenderers(event);

        if (CONFIGS.getDebugConfig().ENABLE_TESTS) {
            try {
                TestSuite.runInitTests();
            } catch (Throwable t) {
                LOGGER.error("[MWR] Error running Init tests", t);
            }
        }
        if (CONFIGS.getDebugConfig().ENABLE_LOAD_LOGS) LOGGER.info("[MWR] Initialization completed.");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (CONFIGS.getDebugConfig().ENABLE_LOAD_LOGS) LOGGER.info("[MWR] Post-initialization started.");
        if (CONFIGS.getDebugConfig().ENABLE_TESTS) {
            try {
                TestSuite.runPostInitTests();
            } catch (Throwable t) {
                LOGGER.error("[MWR] Error running PostInit tests", t);
            }
        }
        if (CONFIGS.getDebugConfig().ENABLE_LOAD_LOGS) LOGGER.info("[MWR] Post-initialization completed.");
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        MWRCommandHandler.registerCommands(event);
    }
}