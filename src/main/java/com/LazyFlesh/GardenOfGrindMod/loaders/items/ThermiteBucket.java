package com.LazyFlesh.GardenOfGrindMod.loaders.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ThermiteBucket extends Item {
    // magnetite + zinc may possibly make a thermite reaction. Do it in a bucket of obsidian dust for lava.

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        Entity newEntity = new EntityItem(world, location.posX, location.posY, location.posZ, itemstack);
        newEntity.fireResistance = Integer.MAX_VALUE;
        return newEntity;
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem aItemEntity) {
        if (aItemEntity != null && !aItemEntity.worldObj.isRemote) {
            int tX = MathHelper.floor_double(aItemEntity.posX);
            int tY = MathHelper.floor_double(aItemEntity.posY);
            int tZ = MathHelper.floor_double(aItemEntity.posZ);
            Block tBlock = aItemEntity.worldObj.getBlock(tX, tY, tZ);
            if ((tBlock == Blocks.fire)) {
                aItemEntity.setEntityItemStack(new ItemStack(Items.lava_bucket));
                aItemEntity.fireResistance = Integer.MAX_VALUE;
                aItemEntity.delayBeforeCanPickup = 0;
                return true;
            }

        }
        return false;
    }
}
