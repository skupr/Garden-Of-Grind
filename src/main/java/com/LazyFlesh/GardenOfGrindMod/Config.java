package com.LazyFlesh.GardenOfGrindMod;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static int challengeMode = 0;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        challengeMode = configuration.getInt(
            "challengeMode",
            Configuration.CATEGORY_GENERAL,
            0,
            0,
            3,
            """
                The mode for the Garden of Grind addon's configuration. 0 for Garden of Grind (no changes except for qb and guideNH pages),\s
                1 for Skyblock (several changes to recipes to make it closer to a skyblock version of GTNH),\s
                2 for Gog easy (lightens several of the worst grinds, like green sapphire or tengam),\s
                and 3 for Quesless Gog (disables quest rewards. Makes minimal changes if a version of GTNH after 2.9 made it incompletable).""");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
