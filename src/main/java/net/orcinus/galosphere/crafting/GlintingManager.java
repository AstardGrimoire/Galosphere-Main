package net.orcinus.galosphere.crafting;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.block.Block;
import net.orcinus.galosphere.Galosphere;

import java.util.Map;

public class GlintingManager extends SimpleJsonResourceReloadListener implements IdentifiableResourceReloadListener {
    private static final Gson GSON_INSTANCE = (new GsonBuilder()).create();
    private static final Map<Block, Block> GLINTING_TABLE = Maps.newHashMap();

    public GlintingManager() {
        super(GSON_INSTANCE, "sparkle_glints");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> object, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        object.forEach((resourceLocation, jsonElement) -> {
            String crystalName = jsonElement.getAsJsonObject().get("crystal_cluster").getAsString();
            String glintedName = jsonElement.getAsJsonObject().get("glinted_cluster").getAsString();
            Block crystalCluster = this.getBlock(crystalName);
            Block glintedCluster = this.getBlock(glintedName);
            GLINTING_TABLE.put(crystalCluster, glintedCluster);
        });
    }

    public static Map<Block, Block> getGlintingTable() {
        return GLINTING_TABLE;
    }

    private Block getBlock(String name) {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.parse(name));
    }

    @Override
    public ResourceLocation getFabricId() {
        return Galosphere.id("sparkle_glints");
    }
}
