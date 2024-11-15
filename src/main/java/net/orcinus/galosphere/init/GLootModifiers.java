package net.orcinus.galosphere.init;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.util.PillagerSilverLootModifier;

import java.util.function.Supplier;

public class GLootModifiers {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Galosphere.MODID);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> PILLAGER_SILVER_LOOT = LOOT_MODIFIERS.register("pillager_silver_loot", () -> PillagerSilverLootModifier.CODEC);

}