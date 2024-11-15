package net.orcinus.galosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;

public class GPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, Galosphere.MODID);

    public static final Holder<Potion> ASTRAL = POTIONS.register("astral", () -> new Potion(new MobEffectInstance(GMobEffects.ASTRAL, 1800)));
    public static final Holder<Potion> LONG_ASTRAL = POTIONS.register("long_astral", () -> new Potion("astral", new MobEffectInstance(GMobEffects.ASTRAL, 3600)));

}
