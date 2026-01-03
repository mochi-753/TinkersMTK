package com.mochi_753.tconstructmtk.datagen;

import com.mochi_753.tconstructmtk.common.material.TinkerMTKMaterialIds;
import com.mochi_753.tconstructmtk.common.registry.TinkerMTKModifiers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;

@MethodsReturnNonnullByDefault
public class TinkerMTKMaterialTraitsProvider extends AbstractMaterialTraitDataProvider {
    public TinkerMTKMaterialTraitsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(TinkerMTKMaterialIds.MTK_TOOL, TinkerMTKModifiers.MTK_TOOL_MODIFIER);
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Material Traits";
    }
}
