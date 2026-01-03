package com.mochi_753.tconstructmtk;

import com.mochi_753.tconstructmtk.common.registry.TinkerMTKFluids;
import com.mochi_753.tconstructmtk.common.registry.TinkerMTKModifiers;
import com.mochi_753.tconstructmtk.common.registry.TinkerMTKTiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TConstructMTK.MOD_ID)
public class TConstructMTK {
    public static final String MOD_ID = "tconstructmtk";

    @SuppressWarnings("removal")
    public TConstructMTK() {
        this(FMLJavaModLoadingContext.get());
    }

    public TConstructMTK(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();

        TinkerMTKFluids.register(eventBus);
        TinkerMTKModifiers.register(eventBus);
        TinkerMTKTiers.init(); // 無意味だけどこれがないと動かない
    }
}
