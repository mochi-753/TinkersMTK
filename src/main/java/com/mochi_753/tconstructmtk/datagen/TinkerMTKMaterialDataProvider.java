package com.mochi_753.tconstructmtk.datagen;

import com.mochi_753.tconstructmtk.common.material.TinkerMTKMaterialIds;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

@MethodsReturnNonnullByDefault
public class TinkerMTKMaterialDataProvider extends AbstractMaterialDataProvider {
    public TinkerMTKMaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        addMaterial(TinkerMTKMaterialIds.MTK_TOOL, 6, ORDER_WEAPON + ORDER_COMPAT, false);
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Materials";
    }
}
