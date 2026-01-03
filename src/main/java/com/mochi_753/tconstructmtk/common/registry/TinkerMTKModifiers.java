package com.mochi_753.tconstructmtk.common.registry;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.modiffier.ModifierMTKTool;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkerMTKModifiers {
    private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TConstructMTK.MOD_ID);

    public static final StaticModifier<NoLevelsModifier> MTK_TOOL_MODIFIER = MODIFIERS.register("mtk_tool", ModifierMTKTool::new);

    public static void register(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }
}
