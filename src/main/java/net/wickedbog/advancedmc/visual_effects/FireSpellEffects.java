package net.wickedbog.advancedmc.visual_effects;

import net.minecraft.client.*;
import net.minecraft.client.player.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.wickedbog.advancedmc.item.ModItems;
import team.lodestar.lodestone.setup.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.easing.*;
import team.lodestar.lodestone.systems.particle.builder.*;
import team.lodestar.lodestone.systems.particle.data.*;
import team.lodestar.lodestone.systems.particle.data.color.*;
import team.lodestar.lodestone.systems.particle.data.spin.*;

import java.awt.Color;
import java.io.Console;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FireSpellEffects {

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
        final LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            if (player.getMainHandItem().getItem() == ModItems.MAGIC_WAND.get()) {
                idleParticle(player.level(), player.position().add(new Vec3(player.getLookAngle().x + 1,2,0)));
            }
        }
    }

        public static void spawnFireParticale (Level level, Vec3 pos, Vec3 motion){
            Color startingColor = new Color(255, 73, 18);
            Color endingColor = new Color(255,25,25,25);
            WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
                    .setScaleData(GenericParticleData.create(0.5f, 0.5f).build())
                    .setTransparencyData(GenericParticleData.create(0.75f, 0.25f).build())
                    .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
                    .setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((level.getGameTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
                    .setLifetime(40)
                    .addMotion(motion)
                    .enableNoClip()
                    .spawn(level, pos.x, pos.y, pos.z);
        }

        public static void idleParticle (Level level, Vec3 pos){
            Color startingColor = new Color(255, 255, 255);
            Color endingColor = new Color(255, 173, 110);
            WorldParticleBuilder.create(LodestoneParticleRegistry.SPARKLE_PARTICLE)
                    .setScaleData(GenericParticleData.create(0.1f, 0.1f).build())
                    .setTransparencyData(GenericParticleData.create(0.75f, 0.25f).build())
                    .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
                    //.setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((level.getGameTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
                    .setLifetime(5)
                    .addMotion(0f, 0f, 0f)
                    .enableNoClip()
                    .spawn(level, pos.x, pos.y, pos.z);
        }
    }