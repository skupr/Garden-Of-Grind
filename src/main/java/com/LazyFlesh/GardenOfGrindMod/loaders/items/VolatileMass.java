package com.LazyFlesh.GardenOfGrindMod.loaders.items;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

public class VolatileMass extends Item {

    @Override
    public boolean onEntityItemUpdate(EntityItem aItemEntity) {
        if (aItemEntity != null && !aItemEntity.worldObj.isRemote) {
            int tX = MathHelper.floor_double(aItemEntity.posX);
            int tY = MathHelper.floor_double(aItemEntity.posY);
            int tZ = MathHelper.floor_double(aItemEntity.posZ);
            Block tBlock = aItemEntity.worldObj.getBlock(tX, tY, tZ);
            if ((tBlock == Blocks.fire)) {
                aItemEntity.setDead();
                for (int i = -1; i <= 1; i += 2) {
                    if (aItemEntity.worldObj.isAirBlock(tX + i, tY, tZ))
                        aItemEntity.worldObj.setBlock(tX + i, tY, tZ, Blocks.flowing_lava, 2, 2);
                }
                for (int j = -1; j <= 1; j += 2) {
                    if (aItemEntity.worldObj.isAirBlock(tX, tY, tZ + j))
                        aItemEntity.worldObj.setBlock(tX, tY, tZ + j, Blocks.flowing_lava, 2, 2);
                }
                aItemEntity.worldObj.setBlock(tX, tY, tZ, Blocks.flowing_lava, 1, 2);
                return true;
            }

        }
        return false;
    }
}
