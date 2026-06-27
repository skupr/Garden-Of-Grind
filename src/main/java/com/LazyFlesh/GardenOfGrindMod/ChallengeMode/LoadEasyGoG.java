package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.multiblockRockBreakerRecipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;
import com.LazyFlesh.GardenOfGrindMod.loaders.GoGItemList;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.recipes.ShapedUniversalRecipe;
import com.dreammaster.recipes.ShapelessUniversalRecipe;
import com.dreammaster.scripts.IngredientFactory;
import com.gtnewhorizon.cropsnh.api.CropsNHItemList;

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
        this.loadQuestlines();
    }

    public static void registerRecipes() {
        try {
            GameRegistry.addRecipe(
                new ShapelessUniversalRecipe(
                    CropsNHItemList.cropSticks.get(1),
                    new ItemStack(Items.bone, 1),
                    new ItemStack(Items.bone, 1),
                    new ItemStack(Items.bone, 1),
                    new ItemStack(Items.bone, 1)));

            GameRegistry.addRecipe(
                new ShapelessUniversalRecipe(
                    CropsNHItemList.cropSticks.get(1),
                    new ItemStack(Items.arrow, 1),
                    new ItemStack(Items.arrow, 1),
                    new ItemStack(Items.arrow, 1),
                    new ItemStack(Items.arrow, 1)));

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
                    new ItemStack(Item.getItemFromBlock(Blocks.gravel), 1)));
        } catch (Exception e) {
            MainRegistry.LOGGER.error("A Garden of Grind Skyblock recipe went wrong:");
            e.printStackTrace();
        }

        GTValues.RA.stdBuilder()
            .circuit(1)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 1000))
            .itemOutputs(getModItem(Mods.Minecraft.ID, "coal", 1, 1, missing))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(2)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 1000))
            .itemOutputs(getModItem(Mods.Minecraft.ID, "redstone", 1, 1, missing))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(3)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 1000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(4)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 1000))
            .itemOutputs(getModItem(Mods.Minecraft.ID, "string", 1, 1, missing))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(5)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 1000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(6)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 1000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(7)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 2000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(8)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 2000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(9)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 2000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(10)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 2000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(11)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 3000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(12)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 3000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(13)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 3000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(14)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 3000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(15)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 4000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(16)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 4000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(17)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 5000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CastIron, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(18)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 7000))
            .itemOutputs(IngredientFactory.getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(19)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 7000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Arsenic, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(20)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 8000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(21)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 8000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Silver, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(22)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 8000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(23)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 8000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
            .circuit(24)
            .fluidInputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 9000))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.CobaltBrass, 1L))
            .duration(16 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);

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
