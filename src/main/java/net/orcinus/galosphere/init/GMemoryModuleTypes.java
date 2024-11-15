package net.orcinus.galosphere.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;

import java.util.Optional;
import java.util.function.Supplier;

public class GMemoryModuleTypes {

    public static final DeferredRegister<MemoryModuleType<?>> MEMORY_MODULE_TYPES = DeferredRegister.create(Registries.MEMORY_MODULE_TYPE, Galosphere.MODID);

    public static final Supplier<MemoryModuleType<BlockPos>> NEAREST_POLLINATED_CLUSTER = MEMORY_MODULE_TYPES.register("nearest_pollinated_cluster", () -> new MemoryModuleType<>(Optional.empty()));
    public static final Supplier<MemoryModuleType<Unit>> POLLINATED_COOLDOWN = MEMORY_MODULE_TYPES.register("pollinated_cooldown", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Boolean>> CAN_BURY = MEMORY_MODULE_TYPES.register("can_bury", () -> new MemoryModuleType<>(Optional.empty()));
    public static final Supplier<MemoryModuleType<BlockPos>> NEAREST_LICHEN_MOSS = MEMORY_MODULE_TYPES.register("nearest_lichen_moss", () -> new MemoryModuleType<>(Optional.empty()));
    public static final Supplier<MemoryModuleType<Unit>> IS_ROARING = MEMORY_MODULE_TYPES.register("roaring", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Unit>> IS_SMASHING = MEMORY_MODULE_TYPES.register("smashing", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Unit>> IS_IMPALING = MEMORY_MODULE_TYPES.register("impaling", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Unit>> IS_SUMMONING = MEMORY_MODULE_TYPES.register("summoning", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Unit>> IS_SHAKING = MEMORY_MODULE_TYPES.register("shaking", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Unit>> SUMMONING_COOLDOWN  = MEMORY_MODULE_TYPES.register("summoning_cooldown", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Unit>> IMPALING_COOLDOWN = MEMORY_MODULE_TYPES.register("impaling_cooldown", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Unit>> SMASHING_COOLDOWN = MEMORY_MODULE_TYPES.register("smashing_cooldown", () -> new MemoryModuleType<>(Optional.of(Codec.unit(Unit.INSTANCE))));
    public static final Supplier<MemoryModuleType<Integer>> IMPALING_COUNT = MEMORY_MODULE_TYPES.register("impaling_count", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));
    public static final Supplier<MemoryModuleType<Integer>> SUMMON_COUNT = MEMORY_MODULE_TYPES.register("summon_count", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));
    public static final Supplier<MemoryModuleType<Integer>> HURT_COUNT = MEMORY_MODULE_TYPES.register("hurt_count", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));
    public static final Supplier<MemoryModuleType<Integer>> RAMPAGE_TICKS = MEMORY_MODULE_TYPES.register("rampage_ticks", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));

}