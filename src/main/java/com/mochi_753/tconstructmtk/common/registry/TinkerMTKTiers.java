package com.mochi_753.tconstructmtk.common.registry;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.tier.MTKTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

@SuppressWarnings("removal")
public class TinkerMTKTiers {
    public static final Tier MTK = TierSortingRegistry.registerTier(
            MTKTier.INSTANCE,
            new ResourceLocation(TConstructMTK.MOD_ID, "mtk"),
            List.of(), List.of()
    );

    public static void init() {
    }
}
