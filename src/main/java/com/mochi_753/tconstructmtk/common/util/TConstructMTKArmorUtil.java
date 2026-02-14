package com.mochi_753.tconstructmtk.common.util;

import com.mochi_753.tconstructmtk.common.registry.TConstructMTKModifiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class TConstructMTKArmorUtil {
    private TConstructMTKArmorUtil() {
    }

    public static boolean isInvincible(LivingEntity livingEntity) {
        if (livingEntity == null || livingEntity.level().isClientSide()) return false;

        ItemStack head = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = livingEntity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = livingEntity.getItemBySlot(EquipmentSlot.FEET);

        return hasModifier(head, TConstructMTKModifiers.MTK_MODIFIER.get())
                || hasModifier(chest, TConstructMTKModifiers.MTK_MODIFIER.get())
                || hasModifier(legs, TConstructMTKModifiers.MTK_MODIFIER.get())
                || hasModifier(feet, TConstructMTKModifiers.MTK_MODIFIER.get());
    }

    public static boolean hasModifier(ItemStack itemStack, Modifier modifier) {
        if (itemStack == null || itemStack.isEmpty()) return false;

        ToolStack toolStack = ToolStack.copyFrom(itemStack);
        int level = toolStack.getModifierLevel(modifier);
        return level > 0;
    }
}
