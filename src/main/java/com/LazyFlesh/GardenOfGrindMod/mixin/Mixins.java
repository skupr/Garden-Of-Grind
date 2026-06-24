package com.LazyFlesh.GardenOfGrindMod.mixin;

import javax.annotation.Nonnull;

import com.LazyFlesh.GardenOfGrindMod.GeneralConfig;
import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import com.gtnewhorizon.gtnhmixins.builders.IBaseTransformer;
import com.gtnewhorizon.gtnhmixins.builders.IMixins;
import com.gtnewhorizon.gtnhmixins.builders.ITargetMod;
import com.gtnewhorizon.gtnhmixins.builders.MixinBuilder;
import com.gtnewhorizon.gtnhmixins.builders.TargetModBuilder;

import cpw.mods.fml.common.versioning.ComparableVersion;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;


public enum Mixins implements IMixins {

    DISABLE_CHUNK_TERRAIN_GENERATION(new MixinBuilder().addCommonMixins("MixinChunkProviderServer_DisableTerrain")
        .setApplyIf(() -> !GeneralConfig.disableGOG)
        .addExcludedMod(TargetedMod.ENDLESSIDS)
        .setPhase(IBaseTransformer.Phase.EARLY)),
    DISABLE_CHUNK_TERRAIN_GENERATION_ENDLESS_IDS(
        new MixinBuilder().addCommonMixins("MixinChunkProviderServer_DisableTerrain_EndlessIDs")
            .setApplyIf(() -> !GeneralConfig.disableGOG)
            .addRequiredMod(TargetedMod.ENDLESSIDS)
            .setPhase(IBaseTransformer.Phase.EARLY)),
    DISABLE_WORLD_TYPE_CHUNK_POPULATION(
        new MixinBuilder("Disable chunk population tied to chunk generation (ores/structure)")
            .addCommonMixins("MixinChunkProviderServer_DisablePopulation")
            .setApplyIf(() -> !GeneralConfig.disableGOG)
            .setPhase(IBaseTransformer.Phase.EARLY)),
    DISABLE_MODDED_CHUNK_POPULATION(new MixinBuilder("Disable all other mod chunk population (e.g. Natura clouds")
        .addCommonMixins("MixinChunkProviderServer_DisableModGeneration")
        .setApplyIf(() -> !GeneralConfig.disableGOG && !GeneralConfig.chaosDragonTime)
        .setPhase(IBaseTransformer.Phase.EARLY));

    private final MixinBuilder builder;

    Mixins(MixinBuilder builder) {
        this.builder = builder;
    }

    @Nonnull
    @Override
    public MixinBuilder getBuilder() {
        return builder;
    }

    public enum TargetedMod implements ITargetMod {

        ENDLESSIDS("com.falsepattern.endlessids.asm.EndlessIDsCore", "endlessids");

        private final TargetModBuilder builder;

        TargetedMod(TargetModBuilder builder) {
            this.builder = builder;
        }

        TargetedMod(String modId) {
            this(null, modId, null);
        }

        TargetedMod(String coreModClass, String modId) {
            this(coreModClass, modId, null);
        }

        TargetedMod(String coreModClass, String modId, String targetClass) {
            this.builder = new TargetModBuilder().setCoreModClass(coreModClass).setModId(modId).setTargetClass(targetClass);
        }

        @Nonnull
        @Override
        public TargetModBuilder getBuilder() {
            return builder;
        }

        private static boolean isVersionLessThan(String version, String target) {
            return new ComparableVersion(version).compareTo(new ComparableVersion(target)) < 0;
        }
    }

    @LateMixin
    public static class LateMixinLoader implements ILateMixinLoader {

        @Override
        public String getMixinConfig() {
            return "mixins.GardenOfGrindMod.late.json";
        }

        @Override
        public @NotNull List<String> getMixins(Set<String> loadedMods) {
            return IMixins.getEarlyMixins(Mixins.class, loadedMods);
        }
    }

}
