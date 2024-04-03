package net.wickedbog.advancedmc.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.wickedbog.advancedmc.AdvancedMC;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(AdvancedMC.MOD_ID, "overworld"), 5)); // Weight is how much it spawns
    }
}
