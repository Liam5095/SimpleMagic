package net.wickedbog.advancedmc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.wickedbog.advancedmc.visual_effects.EnviormentalEffects;

public class SteamVents extends Block {
    public SteamVents(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        EnviormentalEffects.spawnSteamParticles(pLevel, new Vec3(pPos.getX(), pPos.getY(), pPos.getZ()));
    }
}
