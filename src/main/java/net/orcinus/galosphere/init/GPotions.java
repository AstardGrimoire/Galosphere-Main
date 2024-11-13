package net.orcinus.galosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.orcinus.galosphere.Galosphere;

public class GPotions {

    public static final Holder<Potion> ASTRAL = register("astral", new Potion(new MobEffectInstance(GMobEffects.ASTRAL, 1800)));
    public static final Holder<Potion> LONG_ASTRAL = register("long_astral", new Potion("astral", new MobEffectInstance(GMobEffects.ASTRAL, 3600)));

    private static Holder<Potion> register(String string, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, Galosphere.id(string), potion);
    }

    public static void init() {
    }

}
