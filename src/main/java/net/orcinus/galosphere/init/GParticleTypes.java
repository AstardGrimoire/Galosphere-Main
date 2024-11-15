package net.orcinus.galosphere.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;

import java.util.function.Supplier;

public class GParticleTypes {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, Galosphere.MODID);

    public static final Supplier<SimpleParticleType> AURA_RINGER_INDICATOR = registerParticle("aura_ringer_indicator", false);
    public static final Supplier<SimpleParticleType> SILVER_BOMB = registerParticle("item_silverbomb", false);
    public static final Supplier<SimpleParticleType> WARPED = registerParticle("warped", false);
    public static final Supplier<SimpleParticleType> ALLURITE_RAIN = registerParticle("allurite_rain", false);
    public static final Supplier<SimpleParticleType> LUMIERE_RAIN = registerParticle("lumiere_rain", false);
    public static final Supplier<SimpleParticleType> AMETHYST_RAIN = registerParticle("amethyst_rain", false);
    public static final Supplier<SimpleParticleType> SPECTATE_ORB = registerParticle("spectate_orb", false);
    public static final Supplier<SimpleParticleType> PINK_SALT_FALLING_DUST = registerParticle("pink_salt_falling_dust", false);
    public static final Supplier<SimpleParticleType> IMPACT = registerParticle("impact", false);

    public static Supplier<SimpleParticleType> registerParticle(String key, boolean alwaysShow) {
        return PARTICLES.register(key, () -> new SimpleParticleType(alwaysShow));
    }

}
