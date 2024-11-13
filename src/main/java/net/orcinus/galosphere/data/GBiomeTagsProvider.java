package net.orcinus.galosphere.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.orcinus.galosphere.init.GBiomeTags;
import net.orcinus.galosphere.init.GBiomes;

import java.util.concurrent.CompletableFuture;

public class GBiomeTagsProvider extends FabricTagProvider<Biome> {

    public GBiomeTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        GBiomes.BIOMES.values().forEach(this::assignVanillaBiomes);

        this.getOrCreateTagBuilder(GBiomeTags.HAS_PINK_SALT_SHRINE).add(GBiomes.PINK_SALT_CAVES);
        this.getOrCreateTagBuilder(GBiomeTags.HAS_FORGOTTEN_TOMBS).addOptionalTag(BiomeTags.IS_OVERWORLD);
    }

    private void assignVanillaBiomes(ResourceKey<Biome> biomeResourceKey) {
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(biomeResourceKey);
        this.getOrCreateTagBuilder(BiomeTags.STRONGHOLD_BIASED_TO).add(biomeResourceKey);
        this.getOrCreateTagBuilder(BiomeTags.HAS_MINESHAFT).add(biomeResourceKey);
        this.getOrCreateTagBuilder(BiomeTags.HAS_RUINED_PORTAL_STANDARD).add(biomeResourceKey);
        this.getOrCreateTagBuilder(BiomeTags.HAS_TRIAL_CHAMBERS).add(biomeResourceKey);
    }
}
