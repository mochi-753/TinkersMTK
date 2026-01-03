package com.mochi_753.tconstructmtk.common.modiffier;

import com.mochi_753.tconstructmtk.TConstructMTK;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@ParametersAreNonnullByDefault
public class ModifierMTKTool extends NoLevelsModifier implements BreakSpeedModifierHook, ProjectileHitModifierHook, MeleeHitModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.BREAK_SPEED, ModifierHooks.PROJECTILE_HIT, ModifierHooks.MELEE_HIT);
    }

    @Override
    public void onBreakSpeed(IToolStackView iToolStackView, ModifierEntry modifierEntry, PlayerEvent.BreakSpeed breakSpeed, Direction direction, boolean b, float v) {
        breakSpeed.setNewSpeed(Float.MAX_VALUE);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (target != null && !target.level().isClientSide()) {
            LightningBolt lightningBolt = Objects.requireNonNull(EntityType.LIGHTNING_BOLT.create(target.level()));
            lightningBolt.wasOnFire = false;
            if (attacker instanceof ServerPlayer serverPlayer) {
                lightningBolt.moveTo(target.position());
                lightningBolt.setCause(serverPlayer);
                if (!target.isDeadOrDying()) {
                    target.level().addFreshEntity(lightningBolt);
                }
            }

            Holder<DamageType> holder = target.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC);
            target.hurt(new DamageSource(holder), Float.MAX_VALUE);
            target.setHealth(0.0F);
        }

        return ProjectileHitModifierHook.super.onProjectileHitEntity(modifiers, persistentData, modifier, projectile, hit, attacker, target);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        LivingEntity attacker = context.getAttacker();
        Entity entity = context.getTarget();

        Holder<DamageType> holder = entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC);
        DamageSource source = new DamageSource(holder);

        if (entity instanceof LivingEntity target) {
            if(target.distanceToSqr(attacker) > 50.0) {
                LightningBolt lightningBolt = Objects.requireNonNull(EntityType.LIGHTNING_BOLT.create(target.level()));
                lightningBolt.wasOnFire = false;
                if (attacker instanceof ServerPlayer serverPlayer) {
                    lightningBolt.moveTo(target.position());
                    lightningBolt.setCause(serverPlayer);
                    if (!target.isDeadOrDying()) {
                        target.level().addFreshEntity(lightningBolt);
                    }
                }
            }

            target.setInvulnerable(false);
            target.setHealth(0.0F);

            if (!target.isDeadOrDying()) {
                target.hurt(source, Float.MAX_VALUE);
                target.die(source);
            }
        }
    }
}
