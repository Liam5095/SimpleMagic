package net.wickedbog.advancedmc.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
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
    }
}
