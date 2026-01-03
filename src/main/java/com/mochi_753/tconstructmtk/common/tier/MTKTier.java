package com.mochi_753.tconstructmtk.common.tier;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class MTKTier implements Tier {
    public static final MTKTier INSTANCE = new MTKTier();

    @Override
    public int getUses() {
        return Integer.MAX_VALUE;
    }

    @Override
    public float getSpeed() {
        return Float.MAX_VALUE;
    }

    @Override
    public float getAttackDamageBonus() {
        return Float.MAX_VALUE;
    }

    @Override
    public int getLevel() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getEnchantmentValue() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
