package net.wickedbog.advancedmc.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.wickedbog.advancedmc.AdvancedMC;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RUBY_ORE_PLACED_KEY = registerKey("nether_ruby_ore_placed"); // Nether example
    public static final ResourceKey<PlacedFeature> END_RUBY_ORE_PLACED_KEY = registerKey("end_ruby_ore_placed"); // End example

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, // Number of veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(40)))); // Play around with
        // heightrangeplacement watch here for more info https://www.youtube.com/watch?v=GRJyJWtSnvQ&list=PLKGarocXCE1H9Y21-pxjt5Pt8bW14twa-&index=38 10 minutes in
        // Also look at vanilla classes for more info!

        //register(context, NETHER_RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
        //        ModOrePlacement.commonOrePlacement(12,
        //                HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(10))));

        //register(context, END_RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_RUBY_ORE_KEY),
        //        ModOrePlacement.commonOrePlacement(12,
        //                HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(10))));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AdvancedMC.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}