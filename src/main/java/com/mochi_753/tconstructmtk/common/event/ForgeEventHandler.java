package com.mochi_753.tconstructmtk.common.event;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.util.TConstructMTKArmorUtil;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = TConstructMTK.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
    private ForgeEventHandler() {
    }

    private static void cancel(@NotNull LivingEvent event) {
        if (TConstructMTKArmorUtil.isInvincible(event.getEntity())) event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onLivingAttack(@NotNull LivingAttackEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingDeath(@NotNull LivingDeathEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingDamage(@NotNull LivingDamageEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingHurt(@NotNull LivingHurtEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingKnockBack(@NotNull LivingKnockBackEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingDrops(@NotNull LivingDropsEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onExperienceDrop(@NotNull LivingExperienceDropEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.@NotNull PlayerTickEvent event) {
        Player player = event.player;

        if (event.phase == TickEvent.Phase.END && event.side.isServer() && TConstructMTKArmorUtil.isInvincible(player)) {
            player.setHealth(player.getMaxHealth());
            player.getFoodData().setFoodLevel(20);
            player.getFoodData().setSaturation(20.0F);

            for (MobEffectInstance effectInstance : player.getActiveEffects()) {
                if (effectInstance.getEffect().getCategory().equals(MobEffectCategory.HARMFUL)) {
                    player.removeEffect(effectInstance.getEffect());
                }
            }
        }
    }
}
