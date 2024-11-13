package net.orcinus.galosphere.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.util.loot.PreservedPredicate;

public class GEntitySubPredicates {

    public static void init() {
        Registry.register(BuiltInRegistries.ENTITY_SUB_PREDICATE_TYPE, Galosphere.id("preserved"), PreservedPredicate.CODEC);
    }

}
