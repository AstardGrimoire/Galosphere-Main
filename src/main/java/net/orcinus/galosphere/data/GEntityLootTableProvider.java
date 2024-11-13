package net.orcinus.galosphere.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.orcinus.galosphere.init.GBlocks;
import net.orcinus.galosphere.init.GEntityTypes;
import net.orcinus.galosphere.init.GItems;
import net.orcinus.galosphere.util.loot.PreservedPredicate;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class GEntityLootTableProvider extends SimpleFabricLootTableProvider {
    private final CompletableFuture<HolderLookup.Provider> registries;

    public GEntityLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, LootContextParamSets.ENTITY);
        this.registries = registryLookup;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        HolderLookup.Provider registryLookup = this.registries.join();
        biConsumer.accept(GEntityTypes.SPARKLE.getDefaultLootTable(), LootTable.lootTable());
        biConsumer.accept(GEntityTypes.SPECTRE.getDefaultLootTable(), LootTable.lootTable());
        biConsumer.accept(GEntityTypes.SPECTERPILLAR.getDefaultLootTable(), LootTable.lootTable());
        biConsumer.accept(GEntityTypes.BERSERKER.getDefaultLootTable(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(GItems.PRESERVED_TEMPLATE)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(GItems.PRESERVED_FLESH))));
        biConsumer.accept(GEntityTypes.PRESERVED.getDefaultLootTable(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(GBlocks.PINK_SALT_CLUSTER)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(registryLookup, UniformGenerator.between(0.0f, 1.0f))).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(new PreservedPredicate())))));
    }

}
