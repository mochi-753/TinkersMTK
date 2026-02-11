package com.mochi_753.tconstructmtk.datagen.lang;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKFluids;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Objects;

public class TConstructMTKJapaneseLangProvider extends LanguageProvider {
    public TConstructMTKJapaneseLangProvider(PackOutput output) {
        super(output, TConstructMTK.MOD_ID, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        add(Objects.requireNonNull(TConstructMTKFluids.MOLTEN_MTK.getBucket()), "溶融したMTK入りバケツ");

        add("fluid.tconstructmtk.molten_mtk", "溶融したMTK");

        add("material.tconstructmtk.mtk", "まな板");

        add("modifier.tconstructmtk.mtk", "MTK");
        add("modifier.tconstructmtk.mtk.flavor", "かなりまな板だよコレ！");
        add("modifier.tconstructmtk.mtk.description", "まな板の力がその身に宿る... 最強無敵のモディファイア！");

        add("modifier.tconstructmtk.mtk_unbreakable", "不可壊");
        add("modifier.tconstructmtk.mtk_unbreakable.flavor", "かなりまな板だよコレ！");
        add("modifier.tconstructmtk.mtk_unbreakable.description", "まな板が壊れるとでも？");
    }
}
