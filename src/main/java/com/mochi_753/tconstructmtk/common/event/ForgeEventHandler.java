package com.mochi_753.tconstructmtk.common.event;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKModifiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = TConstructMTK.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        if (event.getEntity() instanceof Player player && isInvincible(player)) {
            player.setHealth(player.getMaxHealth());
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player && isInvincible(player)) {
            player.setHealth(player.getMaxHealth());
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player player && isInvincible(player)) {
            player.setHealth(player.getMaxHealth());
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player && isInvincible(player)) {
            player.setHealth(player.getMaxHealth());
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingKnockBack(LivingKnockBackEvent event) {
        if (event.getEntity() instanceof Player player && isInvincible(player)) event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof Player player && isInvincible(player)) event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onExperienceDrop(LivingExperienceDropEvent event) {
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
