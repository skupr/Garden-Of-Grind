package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.multiblockRockBreakerRecipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;
import com.LazyFlesh.GardenOfGrindMod.loaders.GoGItemList;
import com.dreammaster.recipes.ShapedUniversalRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.common.tileentities.machines.basic.MTERockBreaker;

public class LoadEasyGoG extends ModeLoader {

    public LoadEasyGoG() {
        GardenOfGrindMod.LOG.info("Loading Easy Garden of Grind");
        GoGItemList.registerAll();
        this.loadQuestlines();
    }

    public static void registerRecipes() {
        GameRegistry.addRecipe(
            new ShapedUniversalRecipe(
                GoGItemList.ThermiteBucket.get(1),
                "abc",
                "abc",
                " e ",
                'a',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 1),
                'b',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1),
                'c',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1),
                'e',
                new ItemStack(Items.bucket, 1)));

        GameRegistry.addRecipe(
            new ShapedUniversalRecipe(
                GoGItemList.GravelDust.get(1),
                "a  ",
                "b  ",
                "   ",
                'a',
                "craftingToolHardHammer",
                'b',
                new ItemStack(Blocks.gravel, 1)));

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.gravel, 1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Magnetite, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Tetrahedrite, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.CassiteriteSand, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Redstone, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Zinc, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Silver, 1))
            .outputChances(50_00, 40_00, 25_00, 15_00, 10_00, 10_00)
            .circuit(1)
            .duration(1 * SECONDS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.sand, 1, WILDCARD))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.CassiteriteSand, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetSand, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Asbestos, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Mica, 1))
            .outputChances(50_00, 40_00, 25_00, 15_00, 10_00, 10_00)
            .circuit(1)
            .duration(1 * SECONDS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(centrifugeRecipes);

        if (Mods.AppliedEnergistics2.isModLoaded()) {
            GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .circuit(6)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1L))
                .duration(16 * TICKS)
                .eut(TierEU.RECIPE_LV)
                .addTo(multiblockRockBreakerRecipes);

            MTERockBreaker.addRockBreakerRecipe(
                b -> b.sideBlocks(Blocks.water)
                    .anywhereBlocks(Blocks.lava)
                    .inputItem(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), true)
                    .circuit(6)
                    .outputItem(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1L))
                    .duration(16 * TICKS));

        }
    }
}
