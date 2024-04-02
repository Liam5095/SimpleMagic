package net.wickedbog.advancedmc.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.wickedbog.advancedmc.visual_effects.FireSpellEffects;


public class WandItem extends Item {
    public WandItem(Properties pProperties) {
        super(pProperties);
    }

    //@Override
    //public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
    //        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPlayer.position().x,
    //                pPlayer.position().y + 2,
    //                pPlayer.position().z), pPlayer.getLookAngle());
    //    return new InteractionResultHolder<>(InteractionResult.SUCCESS, pPlayer.getItemInHand(pUsedHand));
    //}


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player pPlayer = pContext.getPlayer();
        Level pLevel = pContext.getLevel();
        BlockPos pPos = pContext.getClickedPos();

        if (!pPlayer.isCreative()) {
            pPlayer.getCooldowns().addCooldown(this, 200);
        }

        pContext.getItemInHand().hurtAndBreak(1, pPlayer,
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        LightningBolt Lightning = (LightningBolt) EntityType.LIGHTNING_BOLT.create(pLevel);

        if (Lightning != null) {
            Lightning.moveTo(new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
            pLevel.addFreshEntity(Lightning);
        }

        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
        FireSpellEffects.spawnFireParticale(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));

        pLevel.setBlock(new BlockPos(pPos.getX(), pPos.getY() + 1, pPos.getZ()), Blocks.FIRE.defaultBlockState(), 3);
        pLevel.setBlock(new BlockPos(pPos.getX(), pPos.getY() + 2, pPos.getZ()), Blocks.LAVA.defaultBlockState(), 3);
        pLevel.setBlock(new BlockPos(pPos.getX() + 1, pPos.getY() + 1, pPos.getZ()), Blocks.FIRE.defaultBlockState(), 3);
        pLevel.setBlock(new BlockPos(pPos.getX() - 1, pPos.getY() + 1, pPos.getZ()), Blocks.FIRE.defaultBlockState(), 3);
        pLevel.setBlock(new BlockPos(pPos.getX(), pPos.getY() + 1, pPos.getZ() + 1), Blocks.FIRE.defaultBlockState(), 3);
        pLevel.setBlock(new BlockPos(pPos.getX(), pPos.getY() + 1, pPos.getZ() - 1), Blocks.FIRE.defaultBlockState(), 3);

        pLevel.explode(Lightning ,pPos.getX(), pPos.getY(), pPos.getZ(), 3.0F, Level.ExplosionInteraction.TNT);

        return InteractionResult.SUCCESS;
    }
}
