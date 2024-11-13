package net.orcinus.galosphere.init;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.component.CustomData;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.items.components.SpectreBound;

import java.util.Map;
import java.util.function.UnaryOperator;

public class GDataComponents {
    private static final Map<ResourceLocation, DataComponentType<?>> DATA_COMPONENTS = Maps.newHashMap();

    public static final DataComponentType<Integer> EXPLOSION = register("explosion", builder -> builder.persistent(ExtraCodecs.POSITIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT));
    public static final DataComponentType<Integer> DURATION = register("duration", builder -> builder.persistent(ExtraCodecs.POSITIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT));
    public static final DataComponentType<Integer> BOUNCY = register("bouncy", builder -> builder.persistent(ExtraCodecs.POSITIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT));
    public static final DataComponentType<Boolean> PRESERVED = register("preserved", builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL));
    public static final DataComponentType<SpectreBound> SPECTRE_BOUND = register("spectre_bound", builder -> builder.persistent(SpectreBound.CODEC).networkSynchronized(SpectreBound.STREAM_CODEC).cacheEncoding());
    public static final DataComponentType<CustomData> BOTTLE_ENTITY_DATA = register("bottle_entity_data", builder -> builder.persistent(CustomData.CODEC).networkSynchronized(CustomData.STREAM_CODEC));

    public static void init() {
        DATA_COMPONENTS.forEach((resourceLocation, dataComponentType) -> Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, resourceLocation, dataComponentType));
    }

    private static <T> DataComponentType<T> register(String string, UnaryOperator<DataComponentType.Builder<T>> unaryOperator) {
        DataComponentType<T> type = unaryOperator.apply(DataComponentType.builder()).build();
        DATA_COMPONENTS.put(Galosphere.id(string), type);
        return type;
    }
}
