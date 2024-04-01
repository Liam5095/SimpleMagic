package net.wickedbog.advancedmc.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.wickedbog.advancedmc.visual_effects.FireSpellEffects;


public class WandItem extends Item {
    public WandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
            FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPlayer.position().x,
                    pPlayer.position().y + 2,
                    pPlayer.position().z), pPlayer.getLookAngle());

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, pPlayer.getItemInHand(pUsedHand));
    }
}
