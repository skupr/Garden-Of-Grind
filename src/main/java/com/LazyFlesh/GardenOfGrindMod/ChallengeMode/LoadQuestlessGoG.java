package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;

public class LoadQuestlessGoG extends ModeLoader {

    public LoadQuestlessGoG() {
        GardenOfGrindMod.LOG.info("Loading Questless Garden of Grind");
        loadQuestlines();
    }

}
