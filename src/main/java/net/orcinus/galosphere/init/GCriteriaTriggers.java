package net.orcinus.galosphere.init;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.criterion.GCriterion;

import java.util.function.Supplier;

public class GCriteriaTriggers {

    public static final DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, Galosphere.MODID);

    public static final Supplier<GCriterion> LUMIERE_COMPOST = CRITERION_TRIGGERS.register("lumiere_compost", GCriterion::new);
    public static final Supplier<GCriterion> WARPED_TELEPORT = CRITERION_TRIGGERS.register("warped_teleport", GCriterion::new);
    public static final Supplier<GCriterion> USE_SPECTRE_SPYGLASS = CRITERION_TRIGGERS.register("use_spectre_spyglass", GCriterion::new);
    public static final Supplier<GCriterion> LIGHT_SPREAD = CRITERION_TRIGGERS.register("light_spread", GCriterion::new);
    public static final Supplier<GCriterion> USE_SPECTRE_FLARE = CRITERION_TRIGGERS.register("use_spectre_flare", GCriterion::new);
    public static final Supplier<GCriterion> ACTIVATE_PINK_SALT_CHAMBER = CRITERION_TRIGGERS.register("activate_pink_salt_chamber", GCriterion::new);
}
