package com.mochi_753.tconstructmtk.mixin;

import com.mochi_753.tconstructmtk.common.util.TConstructMTKArmorUtil;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "getHealth", at = @At("RETURN"), cancellable = true)
    private void tconstructmtk$getHealth(CallbackInfoReturnable<Float> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (TConstructMTKArmorUtil.isInvincible(self)) cir.setReturnValue(self.getMaxHealth());
    }
}
