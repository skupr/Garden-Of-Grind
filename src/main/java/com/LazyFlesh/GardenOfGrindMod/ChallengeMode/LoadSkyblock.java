package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;

public class LoadSkyblock extends ModeLoader {

    public LoadSkyblock() {
        GardenOfGrindMod.LOG.info("Loading Skyblock");
        this.loadQuestlines();
    }

}
