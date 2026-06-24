package com.LazyFlesh.GardenOfGrindMod;

import betterquesting.api.storage.BQ_Settings;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadEasyGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadQuestlessGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadSkyblock;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        GardenOfGrindMod.LOG.info("I am the Garden of Grind addon mod at version " + Tags.VERSION);

        switch (Config.challengeMode) {
            case 1 -> new LoadEasyGoG();
            case 2 -> new LoadSkyblock();
            case 3 -> new LoadQuestlessGoG();
            default -> new LoadGoG();
        }

    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {}

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        if (Config.challengeMode == 3) {
            // disable rewards for questless gog
            BQ_Settings.noRewards = true;
        }


    }

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
