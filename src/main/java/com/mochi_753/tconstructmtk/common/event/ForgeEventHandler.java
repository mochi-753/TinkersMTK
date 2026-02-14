package com.mochi_753.tconstructmtk.common.event;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKModifiers;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = TConstructMTK.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
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

        if (event.phase == TickEvent.Phase.END && event.side.isServer() && isInvincible(player)) {
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

    private static void cancel(@NotNull LivingEvent event) {
        if (event.getEntity() instanceof Player player && isInvincible(player)) event.setCanceled(true);
    }

    private static boolean isInvincible(Player player) {
        if (player == null || player.level().isClientSide()) return false;

        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        return hasModifier(head, TConstructMTKModifiers.MTK_MODIFIER.get())
                || hasModifier(chest, TConstructMTKModifiers.MTK_MODIFIER.get())
                || hasModifier(legs, TConstructMTKModifiers.MTK_MODIFIER.get())
                || hasModifier(feet, TConstructMTKModifiers.MTK_MODIFIER.get());
    }

    private static boolean hasModifier(ItemStack itemStack, Modifier modifier) {
        if (itemStack == null || itemStack.isEmpty()) return false;

        ToolStack toolStack = ToolStack.copyFrom(itemStack);
        int level = toolStack.getModifierLevel(modifier);
        return level > 0;
    }
}
