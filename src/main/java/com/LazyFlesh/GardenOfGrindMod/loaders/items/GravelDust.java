package com.LazyFlesh.GardenOfGrindMod.loaders.items;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class GravelDust extends Item {

    @Override
    public boolean onEntityItemUpdate(EntityItem aItemEntity) {
        if (aItemEntity != null && !aItemEntity.worldObj.isRemote) {
            int tX = MathHelper.floor_double(aItemEntity.posX);
            int tY = MathHelper.floor_double(aItemEntity.posY);
            int tZ = MathHelper.floor_double(aItemEntity.posZ);
            Block tBlock = aItemEntity.worldObj.getBlock(tX, tY, tZ);
            int tMetaData = aItemEntity.worldObj.getBlockMetadata(tX, tY, tZ);
            if ((tBlock == Blocks.cauldron) && (tMetaData > 0)) {
                int[] outputs = { 0, 0, 0 };
                // for each gravel item, roll for magnetite (40%), chalcopyrite (20%), or cassiterite (20%)
                for (int i = 1; i <= aItemEntity.getEntityItem().stackSize; i++) {
                    int rand = aItemEntity.worldObj.rand.nextInt(100);
                    if (rand < 20) continue;
                    else if (rand < 60) outputs[0]++;
                    else if (rand < 80) outputs[1]++;
                    else outputs[2]++;
                }

                for (int i = 0; i < 3; i++) {
                    if (outputs[i] > 0) {
                        ItemStack drop = i == 0
                            ? GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Magnetite, outputs[i])
                            : i == 1 ? GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Chalcopyrite, outputs[i])
                                : GTOreDictUnificator
                                    .get(OrePrefixes.dustImpure, Materials.CassiteriteSand, outputs[i]);
                        aItemEntity.worldObj.spawnEntityInWorld(
                            new EntityItem(
                                aItemEntity.worldObj,
                                aItemEntity.posX,
                                aItemEntity.posY,
                                aItemEntity.posZ,
                                drop));
                    }
                }
                aItemEntity.worldObj.setBlockMetadataWithNotify(tX, tY, tZ, tMetaData - 1, 3);
                aItemEntity.setDead();
                aItemEntity.getEntityItem().stackSize = 0;
                return true;
            } else if (tBlock == Blocks.water || tBlock == Blocks.flowing_water) {
                int[] outputs = new int[] { 0, 0, 0 };
                // for each gravel item, roll for magnetite (20%), chalcopyrite (10%), or cassiterite (10%)
                for (int i = 1; i <= aItemEntity.getEntityItem().stackSize; i++) {
                    int rand = aItemEntity.worldObj.rand.nextInt(100);
                    if (rand < 60) continue;
                    else if (rand < 80) outputs[0]++;
                    else if (rand < 90) outputs[1]++;
                    else outputs[2]++;
                }

                for (int i = 0; i < 3; ++i) {
                    if (outputs[i] > 0) {
                        ItemStack drop = i == 0
                            ? GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Magnetite, outputs[i])
                            : i == 1 ? GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Chalcopyrite, outputs[i])
                                : GTOreDictUnificator
                                    .get(OrePrefixes.dustImpure, Materials.CassiteriteSand, outputs[i]);
                        aItemEntity.worldObj.spawnEntityInWorld(
                            new EntityItem(
                                aItemEntity.worldObj,
                                aItemEntity.posX,
                                aItemEntity.posY,
                                aItemEntity.posZ,
                                drop));
                    }
                }
                aItemEntity.setDead();
                aItemEntity.getEntityItem().stackSize = 0;
                return true;
            }

        }
        return false;
    }
}
