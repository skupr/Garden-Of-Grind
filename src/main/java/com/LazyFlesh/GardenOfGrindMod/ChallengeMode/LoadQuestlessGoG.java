package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;

import betterquesting.api.storage.BQ_Settings;

public class LoadQuestlessGoG extends ModeLoader {

    public LoadQuestlessGoG() {
        GardenOfGrindMod.LOG.info("Loading Questless Garden of Grind");
        // disable rewards for questless gog
        BQ_Settings.noRewards = true;
        loadQuestlines();
    }

    public static void registerRecipes() {
        // do nothing. No recipe changes required yet.
    }
}
