package net.wickedbog.advancedmc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.wickedbog.advancedmc.AdvancedMC;
import net.wickedbog.advancedmc.block.ModBlocks;
import net.wickedbog.advancedmc.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AdvancedMC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.RUBY_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_ORE.get(),
                        ModBlocks.RUBY_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_ORE.get(),
                ModBlocks.RUBY_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
        this.tag(BlockTags.NEEDS_STONE_TOOL);
        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL);
        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL);
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
    }
}