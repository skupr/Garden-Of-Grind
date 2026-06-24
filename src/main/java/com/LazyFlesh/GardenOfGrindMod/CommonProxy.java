package com.LazyFlesh.GardenOfGrindMod;

import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadEasyGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadQuestlessGoG;
import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.LoadSkyblock;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import com.mitchej123.hodgepodge.config.TweaksConfig;

import betterquesting.api.storage.BQ_Settings;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import gregtech.common.config.Worldgen;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationManager.reloadConfig(GeneralConfig.class, "runtime");

        GardenOfGrindMod.LOG.info("I am the Garden of Grind addon mod at version " + Tags.VERSION);

        switch (GeneralConfig.challengeMode) {
            case 1 -> new LoadEasyGoG();
            case 2 -> new LoadSkyblock();
            case 3 -> new LoadQuestlessGoG();
            default -> new LoadGoG();
        }

        // disable config things for gog
        // the hodgepodge mixins have been copied here, too, bceause early mixins are hard to toggle config on.
        Worldgen.endAsteroids.generateEndAsteroids = false;
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        if (GeneralConfig.challengeMode == 3) {
            // disable rewards for questless gog
            BQ_Settings.noRewards = true;
        }
    }

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
