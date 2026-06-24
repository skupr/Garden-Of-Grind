package com.LazyFlesh.GardenOfGrindMod.coremod;

import net.minecraft.launchwrapper.IClassTransformer;

public class GardenOfGrindModTransformer implements IClassTransformer  {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        return new byte[0];
    }
}
