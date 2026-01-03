package com.mochi_753.tconstructmtk.datagen.material;

import com.mochi_753.tconstructmtk.common.material.TinkerMTKMaterialIds;
import com.mochi_753.tconstructmtk.common.registry.TinkerMTKTiers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

@MethodsReturnNonnullByDefault
public class TinkerMTKMaterialStatsDataProvider extends AbstractMaterialStatsDataProvider {
    public TinkerMTKMaterialStatsDataProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMaterialStats(TinkerMTKMaterialIds.MTK_TOOL,
                new HeadMaterialStats(Integer.MAX_VALUE, Float.MAX_VALUE, TinkerMTKTiers.MTK, Float.MAX_VALUE),
                HandleMaterialStats.multipliers().attackDamage(Integer.MAX_VALUE).attackSpeed(Integer.MAX_VALUE).durability(Integer.MAX_VALUE).miningSpeed(Integer.MAX_VALUE).build(),
                StatlessMaterialStats.BINDING);
        addMaterialStats(TinkerMTKMaterialIds.MTK_TOOL,
                new LimbMaterialStats(Integer.MAX_VALUE, Float.MAX_VALUE, 100.0F, 100.0F),
                new GripMaterialStats(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE));
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Material Stats";
    }
}
