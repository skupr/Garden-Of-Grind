package com.LazyFlesh.GardenOfGrindMod;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config.RequiresMcRestart
@Config(modid = GardenOfGrindMod.MODID)
public class GeneralConfig {

    @Config.Comment("""
        The mode for the Garden of Grind addon's configuration. \s
        0 (or any undefined int) for Garden of Grind (no changes except for qb and guideNH pages),\s
        1 for Skyblock (several changes to recipes to make it closer to a skyblock version of GTNH),\s
        2 for Gog easy (lightens several of the worst grinds, like green sapphire or tengam),\s
        and 3 for Questless Gog (disables quest rewards. Makes minimal changes if a version of GTNH after 2.9 made it incompletable).""")
    @Config.DefaultInt(0)
    @Config.RangeInt(min = 0, max = 3)
    public static int challengeMode;

    @Config.Comment("Toggle config when it's time to fight the chaos dragon, then restart game. Re-enables modded chunk population")
    @Config.DefaultBoolean(false)
    public static boolean chaosDragonTime;

    @Config.Comment("Disable gog world gen configurations. World will populate chunks as normal.")
    @Config.DefaultBoolean(false)
    public static boolean disableGOG;

}
