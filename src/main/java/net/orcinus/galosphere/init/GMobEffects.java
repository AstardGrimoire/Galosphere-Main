package net.orcinus.galosphere.init;

import com.google.common.collect.Maps;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.effects.GMobEffect;

import java.util.Map;

public class GMobEffects {
    public static final Map<ResourceLocation, MobEffect> MOB_EFFECTS = Maps.newLinkedHashMap();

    public static final Holder<MobEffect> ASTRAL = register("astral", new GMobEffect(MobEffectCategory.BENEFICIAL, 12891319));
    public static final Holder<MobEffect> BLOCK_BANE = register("block_bane", new GMobEffect(MobEffectCategory.HARMFUL, 7612935));

    public static Holder<MobEffect> register(String name, MobEffect effect) {
        ResourceLocation id = Galosphere.id(name);
        MOB_EFFECTS.put(id, effect);
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, id, effect);
    }

    public static void init() {
    }

}
