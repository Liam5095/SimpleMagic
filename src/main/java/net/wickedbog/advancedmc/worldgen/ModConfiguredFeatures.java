package net.wickedbog.advancedmc.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.wickedbog.advancedmc.AdvancedMC;
import net.wickedbog.advancedmc.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CRYSTAL_GEODE_KEY = registerKey("crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore"); // NETHER EXAMPLE
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_RUBY_ORE_KEY = registerKey("end_ruby_ore"); // END EXAMPLE

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 4)); // Size is vein size! OVERWORLD

        register(context, OVERWORLD_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.DEEPSLATE),
                        BlockStateProvider.simple(ModBlocks.RED_CRYSTAL.get()),
                        BlockStateProvider.simple(ModBlocks.GREEN_CRYSTAL.get()),
                        BlockStateProvider.simple(ModBlocks.BLUE_CRYSTAL.get()),
                        List.of(ModBlocks.RED_CRYSTAL.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));

        //register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
        // ModBlocks.NETHERORE.get().defaultBlockState(), 4)); NETHER ORE EXAMPLE

        //register(context, END_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
        // ModBlocks.ENDORE.get().defaultBlockState(), 4)); END ORE EXAMPLE


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AdvancedMC.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
