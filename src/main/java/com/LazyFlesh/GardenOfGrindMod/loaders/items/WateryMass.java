package com.LazyFlesh.GardenOfGrindMod.loaders.items;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

public class WateryMass extends Item {

    @Override
    public boolean onEntityItemUpdate(EntityItem aItemEntity) {
        if (aItemEntity != null && !aItemEntity.worldObj.isRemote) {
            int tX = MathHelper.floor_double(aItemEntity.posX);
            int tY = MathHelper.floor_double(aItemEntity.posY);
            int tZ = MathHelper.floor_double(aItemEntity.posZ);
            Block tBlock = aItemEntity.worldObj.getBlock(tX, tY, tZ);
            if ((tBlock == Blocks.fire)) {
                aItemEntity.setDead();
                aItemEntity.worldObj.setBlock(tX, tY, tZ, Blocks.flowing_water, 0, 2);
                return true;
            }

        }
        return false;
    }
}
