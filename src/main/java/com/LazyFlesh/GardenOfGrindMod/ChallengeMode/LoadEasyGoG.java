package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;

public class LoadEasyGoG extends ModeLoader {

    public LoadEasyGoG() {
        GardenOfGrindMod.LOG.info("Loading Easy Garden of Grind");
        this.loadQuestlines();
    }

    public static void registerRecipes() {
        // do nothing. No recipe changes required yet.
    }
}
