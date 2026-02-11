package com.mochi_753.tconstructmtk.common.modiffier;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.hook.armor.ModifyDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModifierMTKArmor extends NoLevelsModifier implements ModifyDamageModifierHook {
    @Override
    public Component getDisplayName() {
        return ((MutableComponent) super.getDisplayName()).withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public Component getDisplayName(int level) {
        return this.getDisplayName();
    }

    @Override
    public float modifyDamageTaken(IToolStackView iToolStackView, ModifierEntry modifierEntry, EquipmentContext equipmentContext, EquipmentSlot equipmentSlot, DamageSource damageSource, float v, boolean b) {
        return 0;
    }
}
