package net.orcinus.galosphere.datagen;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GLootTableProvider extends LootTableProvider {

    public GLootTableProvider(PackOutput packoutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packoutput, Set.of(), ImmutableList.of(), completableFuture);
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return ImmutableList.of(
                new SubProviderEntry(GBlockLootTables::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(GEntityLootTables::new, LootContextParamSets.ENTITY),
                new SubProviderEntry(GChestLootTables::new, LootContextParamSets.CHEST)
        );
    }

}
