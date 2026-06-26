package com.LazyFlesh.GardenOfGrindMod.loaders;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;
import com.LazyFlesh.GardenOfGrindMod.loaders.items.GravelDust;
import com.LazyFlesh.GardenOfGrindMod.loaders.items.ThermiteBucket;

import cpw.mods.fml.common.registry.GameRegistry;

public enum GoGItemList {

    ThermiteBucket("ThermiteBucket", new ThermiteBucket()),
    GravelDust("GravelDust", new GravelDust()),

    // because it's a pattern to use a comma, and breaking a pattern sucks
    ;

    // =====================================

    public final String name;
    public final Item item;

    static {
        ThermiteBucket.item.setMaxStackSize(1);
    }

    GoGItemList(String name, Item item) {
        this.name = name;
        this.item = item;

        item.setUnlocalizedName(name);
        item.setTextureName(GardenOfGrindMod.MODID + ":item" + name);
    }

    public ItemStack get() {
        return new ItemStack(item, 1);
    }

    public ItemStack get(int amount) {
        return new ItemStack(item, amount);
    }

    public static void registerAll() {
        for (final var entry : GoGItemList.values()) {
            GameRegistry.registerItem(entry.item, entry.name);
        }
    }
}
