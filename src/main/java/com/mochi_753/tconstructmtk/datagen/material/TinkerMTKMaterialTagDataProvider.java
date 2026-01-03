package com.mochi_753.tconstructmtk.datagen.material;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.material.TinkerMTKMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.common.data.tags.MaterialTagProvider;

@SuppressWarnings("removal")
public class TinkerMTKMaterialTagDataProvider extends MaterialTagProvider {
    public TinkerMTKMaterialTagDataProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TinkerTags.Materials.EXCLUDE_FROM_LOOT).addOptional(new ResourceLocation(TConstructMTK.MOD_ID, TinkerMTKMaterialIds.MTK_TOOL.getPath()));
    }
}
