package net.orcinus.galosphere.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.orcinus.galosphere.Galosphere;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Galosphere.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        boolean client = event.includeClient();
        boolean server = event.includeServer();
        dataGenerator.addProvider(client, new GBlockstateProvider(packOutput, helper));
        dataGenerator.addProvider(client, new GItemModelProvider(packOutput, helper));
        dataGenerator.addProvider(server, new GAdvancementProvider(packOutput, lookupProvider, helper));
        dataGenerator.addProvider(server, new GLanguageProvider(packOutput));
        dataGenerator.addProvider(server, new GRecipeProvider(packOutput, lookupProvider));
        GBlockTagsProvider blockTagsProvider = new GBlockTagsProvider(packOutput, lookupProvider, helper);
        dataGenerator.addProvider(server, blockTagsProvider);
        dataGenerator.addProvider(server, new GItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), helper));
        dataGenerator.addProvider(server, new GEntityTypeTagsProvider(packOutput, lookupProvider, helper));
        dataGenerator.addProvider(server, new GBiomeTagsProvider(packOutput, lookupProvider, helper));
        dataGenerator.addProvider(server, new GEnchantmentTagsProvider(packOutput, lookupProvider));
        dataGenerator.addProvider(server, new GDatapackBuiltinEntriesProvider(packOutput, lookupProvider));
        dataGenerator.addProvider(server, new GLootTableProvider(packOutput, lookupProvider));
        dataGenerator.addProvider(server, new GLootModifierProvider(packOutput, lookupProvider));
    }

}
