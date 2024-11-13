package net.orcinus.galosphere.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.orcinus.galosphere.init.GEnchantments;

import java.util.concurrent.CompletableFuture;

public class GEnchantmentsProvider extends FabricDynamicRegistryProvider {

    public GEnchantmentsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        GEnchantments.ENCHANTMENTS.values().forEach(enchantmentResourceKey -> add(registries, entries, enchantmentResourceKey));
    }

    private void add(HolderLookup.Provider registries, Entries entries, ResourceKey<Enchantment> resourceKey) {
        final HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);

        entries.add(resourceKey, enchantmentLookup.getOrThrow(resourceKey).value());
    }

    @Override
    public String getName() {
        return "enchantment";
    }
}
