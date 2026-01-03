package com.mochi_753.tconstructmtk.datagen;

import com.mochi_753.tconstructmtk.TConstructMTK;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TConstructMTK.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new TinkerMTKFluidTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TinkerMTKFluidTextureProvider(packOutput));

        TinkerMTKMaterialDataProvider materialDataProvider = new TinkerMTKMaterialDataProvider(packOutput);
        generator.addProvider(event.includeServer(), materialDataProvider);
        generator.addProvider(event.includeServer(), new TinkerMTKMaterialTraitsProvider(packOutput, materialDataProvider));
        generator.addProvider(event.includeServer(), new TinkerMTKMaterialStatsDataProvider(packOutput, materialDataProvider));
        generator.addProvider(event.includeServer(), new TinkerMTKMaterialTagDataProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new TinkerMTKRecipeProvider(packOutput));
    }
}
