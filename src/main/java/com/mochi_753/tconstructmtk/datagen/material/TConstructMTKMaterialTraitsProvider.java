package com.mochi_753.tconstructmtk.datagen.material;

import com.mochi_753.tconstructmtk.common.material.TConstructMTKMaterialIds;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKModifiers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;

@MethodsReturnNonnullByDefault
public class TConstructMTKMaterialTraitsProvider extends AbstractMaterialTraitDataProvider {
    public TConstructMTKMaterialTraitsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(TConstructMTKMaterialIds.MTK_TOOL, TConstructMTKModifiers.MTK_TOOL_MODIFIER, TConstructMTKModifiers.MTK_UNBREAKABLE);
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Material Traits";
    }
}
