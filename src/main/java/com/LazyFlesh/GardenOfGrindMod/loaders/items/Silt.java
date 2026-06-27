package com.LazyFlesh.GardenOfGrindMod.loaders.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class Silt extends Item {

    @Override
    public void addInformation(ItemStack iS, EntityPlayer player, List<String> info, boolean show) {
        info.add(StatCollector.translateToLocal("gog.SiltDust.desc.1"));
        info.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("gog.SiltDust.desc.2"));
        super.addInformation(iS, player, info, show);
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem aItemEntity) {
        if (aItemEntity != null && !aItemEntity.worldObj.isRemote) {
            int tX = MathHelper.floor_double(aItemEntity.posX);
            int tY = MathHelper.floor_double(aItemEntity.posY);
            int tZ = MathHelper.floor_double(aItemEntity.posZ);
            Block tBlock = aItemEntity.worldObj.getBlock(tX, tY, tZ);
            int tMetaData = aItemEntity.worldObj.getBlockMetadata(tX, tY, tZ);
            if (tBlock == Blocks.water || tBlock == Blocks.flowing_water
                || (tBlock == Blocks.cauldron) && (tMetaData > 0)) {
                aItemEntity.setEntityItemStack(
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, aItemEntity.getEntityItem().stackSize));
                aItemEntity.delayBeforeCanPickup = 0;
                return true;
            }

        }
        return false;
    }

}
