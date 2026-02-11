package com.mochi_753.tconstructmtk.common.event;

import com.mochi_753.tconstructmtk.TConstructMTK;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TConstructMTK.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        event.setAmount(Float.POSITIVE_INFINITY);
    }
}
