package com.mochi_753.tconstructmtk.datagen.lang;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TinkerMTKFluids;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Objects;

public class TinkerMTKEnglishLangProvider extends LanguageProvider {
    public TinkerMTKEnglishLangProvider(PackOutput output) {
        super(output, TConstructMTK.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(Objects.requireNonNull(TinkerMTKFluids.MOLTEN_MTK.getBucket()), "Molten MTK Bucket");

        add("fluid.tconstructmtk.molten_mtk", "Molten MTK");

        add("material.tconstructmtk.mtk_tool", "Manaita");

        add("modifier.tconstructmtk.mtk_tool", "MTK");
        add("modifier.tconstructmtk.mtk_tool.flavor", "Manaita POWEERRRR!!!");
        add("modifier.tconstructmtk.mtk_tool.description", "The might of the Manaita resides within you — the ultimate, invincible modifier.");
    }
}
