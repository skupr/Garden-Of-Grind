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

public class WateryMass extends Item {

    @Override
    public void addInformation(ItemStack iS, EntityPlayer player, List<String> info, boolean show) {
        info.add(StatCollector.translateToLocal("gog.WateryMass.desc.1"));
        info.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("gog.WateryMass.desc.2"));
        super.addInformation(iS, player, info, show);
    }

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
