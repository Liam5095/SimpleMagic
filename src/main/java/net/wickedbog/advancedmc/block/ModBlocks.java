package net.wickedbog.advancedmc.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wickedbog.advancedmc.AdvancedMC;
import net.wickedbog.advancedmc.block.custom.Crystal;
import net.wickedbog.advancedmc.block.custom.SteamVents;
import net.wickedbog.advancedmc.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancedMC.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final RegistryObject<Block> BLUE_CRYSTAL = registerBlock("blue_crystal",
            () -> new Crystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1f).noOcclusion()));
    public static final RegistryObject<Block> RED_CRYSTAL = registerBlock("red_crystal",
            () -> new Crystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1f).noOcclusion()));
    public static final RegistryObject<Block> GREEN_CRYSTAL = registerBlock("green_crystal",
            () -> new Crystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1f).noOcclusion()));

    public static final RegistryObject<Block> STEAM_VENT = registerBlock("steam_vent",
            () -> new SteamVents(BlockBehaviour.Properties.copy(Blocks.IRON_TRAPDOOR)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
