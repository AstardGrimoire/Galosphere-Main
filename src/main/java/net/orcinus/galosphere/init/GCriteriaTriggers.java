package net.orcinus.galosphere.init;

import com.google.common.collect.Maps;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.criterion.GCriterion;

import java.util.Map;

public class GCriteriaTriggers {
    public static final Map<ResourceLocation, CriterionTrigger<?>> CRITERION_TRIGGERS = Maps.newHashMap();

    public static final GCriterion LUMIERE_COMPOST = register("lumiere_compost");
    public static final GCriterion WARPED_TELEPORT = register("warped_teleport");
    public static final GCriterion USE_SPECTRE_SPYGLASS = register("use_spectre_spyglass");
    public static final GCriterion LIGHT_SPREAD = register("light_spread");
    public static final GCriterion USE_SPECTRE_FLARE = register("use_spectre_flare");
    public static final GCriterion ACTIVATE_PINK_SALT_CHAMBER = register("activate_pink_salt_chamber");

    private static GCriterion register(String name) {
        return register(name, new GCriterion());
    }

    private static <T extends CriterionTrigger<?>> T register(String name, T criterionTrigger) {
        CRITERION_TRIGGERS.put(Galosphere.id(name), criterionTrigger);
        return criterionTrigger;
    }

    public static void init() {
        CRITERION_TRIGGERS.forEach((resourceLocation, criterionTrigger) -> Registry.register(BuiltInRegistries.TRIGGER_TYPES, resourceLocation, criterionTrigger));
    }

}
