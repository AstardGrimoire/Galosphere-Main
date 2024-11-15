package net.orcinus.galosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.effects.GMobEffect;

public class GMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Galosphere.MODID);

    public static final Holder<MobEffect> ASTRAL = MOB_EFFECTS.register("astral", () -> new GMobEffect(MobEffectCategory.BENEFICIAL, 12891319));
    public static final Holder<MobEffect> BLOCK_BANE = MOB_EFFECTS.register("block_bane", () -> new GMobEffect(MobEffectCategory.HARMFUL, 7612935));

}
