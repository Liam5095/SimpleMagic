package net.wickedbog.advancedmc.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.wickedbog.advancedmc.AdvancedMC;
import net.wickedbog.advancedmc.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.RUBY.get()),
                        Component.literal("A new beginning"), Component.literal("The power lies in the Ruby!"),
                        new ResourceLocation(AdvancedMC.MOD_ID, "textures/block/ruby_ore.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                .save(saver, new ResourceLocation(AdvancedMC.MOD_ID, "advancedmc"), existingFileHelper);



        Advancement Rubyfashion = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.RUBY_CHESTPLATE.get()),
                        Component.literal("Ruby-fashion"), Component.literal("Get a full set of ruby armor"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_full_ruby_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY_HELMET.get(),
                        ModItems.RUBY_CHESTPLATE.get(), ModItems.RUBY_LEGGINGS.get(), ModItems.RUBY_BOOTS.get()))
                .save(saver, new ResourceLocation(AdvancedMC.MOD_ID, "ruby_fashion"), existingFileHelper);



        Advancement AMagicalWand = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.MAGIC_WAND.get()),
                        Component.literal("A Magical Wand"), Component.literal("Get a Magic Wand"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_magic_wand", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MAGIC_WAND.get()))
                .save(saver, new ResourceLocation(AdvancedMC.MOD_ID, "a_magical_wand"), existingFileHelper);

        Advancement TEST = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.RUBY.get()),
                        Component.literal("test"), Component.literal("Here i test the advancments"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("test_criterion", ConsumeItemTrigger.TriggerInstance.usedItem(ModItems.RUBY.get()))
                .save(saver, new ResourceLocation(AdvancedMC.MOD_ID, "test_criterion"), existingFileHelper);
    }
}
