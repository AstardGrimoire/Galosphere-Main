package net.orcinus.galosphere.init;

import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.orcinus.galosphere.Galosphere;

import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

public interface GEnchantmentEffectComponents {
    Map<ResourceLocation, DataComponentType<?>> DATA_COMPONENTS = Maps.newLinkedHashMap();

    DataComponentType<List<ConditionalEffect<EnchantmentValueEffect>>> SALTBOUND_TABLET_DECELERATION = register("saltbound_tablet_deceleration", (builder) -> {
        return builder.persistent(ConditionalEffect.codec(EnchantmentValueEffect.CODEC, LootContextParamSets.ENCHANTED_ENTITY).listOf());
    });
    DataComponentType<List<ConditionalEffect<EnchantmentValueEffect>>> SALTBOUND_TABLET_SUSTAIN = register("saltbound_tablet_sustain", (builder) -> {
        return builder.persistent(ConditionalEffect.codec(EnchantmentValueEffect.CODEC, LootContextParamSets.ENCHANTED_ENTITY).listOf());
    });
    DataComponentType<List<ConditionalEffect<EnchantmentValueEffect>>> SALTBOUND_TABLET_RUPTURE = register("saltbound_tablet_rupture", (builder) -> {
        return builder.persistent(ConditionalEffect.codec(EnchantmentValueEffect.CODEC, LootContextParamSets.ENCHANTED_ENTITY).listOf());
    });

    private static <T> DataComponentType<T> register(String string, UnaryOperator<DataComponentType.Builder<T>> unaryOperator) {
        DataComponentType<T> type = unaryOperator.apply(DataComponentType.builder()).build();
        DATA_COMPONENTS.put(Galosphere.id(string), type);
        return type;
    }

    static void init() {
        DATA_COMPONENTS.forEach((resourceLocation, dataComponentType) -> Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, resourceLocation, dataComponentType));
    }

}
