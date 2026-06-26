package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;

public class LoadGoG extends ModeLoader {

    public LoadGoG() {
        GardenOfGrindMod.LOG.info("Loading Garden of Grind");
        this.loadQuestlines();
        // and do nothing else because this is the default
    }

    public static void registerRecipes() {
        // do nothing. No recipe changes required yet.
    }
}
