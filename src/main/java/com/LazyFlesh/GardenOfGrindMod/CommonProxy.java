package com.LazyFlesh.GardenOfGrindMod;

import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadEasyGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadQuestlessGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadSkyblock;
import com.LazyFlesh.GardenOfGrindMod.commands.GardenOfGrindCommands;
import com.LazyFlesh.GardenOfGrindMod.loaders.meteors.meteors;
import com.hfstudio.bqapi.BQApiMod;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import gregtech.GTMod;
import gregtech.api.enums.Mods;
import gregtech.common.config.Worldgen;

public class CommonProxy {

    public static boolean bqApi;
    public static boolean bloodMagic;

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {

        bqApi = Loader.isModLoaded(BQApiMod.MODID);
        bloodMagic = Mods.BloodMagic.isModLoaded();

        GardenOfGrindMod.LOG.info("I am the Garden of Grind addon mod at version " + Tags.VERSION);
        if (!bqApi) GardenOfGrindMod.LOG.warn("BQApi not found. Skipping adding quests!");

        switch (GeneralConfig.challengeMode) {
            case 1 -> new LoadSkyblock();
            case 2 -> new LoadEasyGoG();
            case 3 -> new LoadQuestlessGoG();

            default -> new LoadGoG();
        }

        // disable config things for gog
        // the hodgepodge mixins have been portede here, because early mixins are hard to toggle config on.
        Worldgen.endAsteroids.generateEndAsteroids = false;
        // disable entity cramming (makes mob farms behave better)
        GTMod.proxy.mMaxEqualEntitiesAtOneSpot = -1;
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        switch (GeneralConfig.challengeMode) {
            case 1 -> {
                LoadSkyblock.registerRecipes();
                if (bloodMagic) meteors.overrideConfig();
            }
            case 2 -> {
                LoadEasyGoG.registerRecipes();
                if (bloodMagic) meteors.overrideConfig();
            }
            case 3 -> LoadQuestlessGoG.registerRecipes();

            default -> LoadGoG.registerRecipes();
        }

    }

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        // not yet implemented
        event.registerServerCommand(new GardenOfGrindCommands());
    }
}
