package net.orcinus.galosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.orcinus.galosphere.Galosphere;

public class GAttributes {

    public static final Holder<Attribute> ILLAGER_RESISTANCE = registerAttribute("illager_resistance", (new RangedAttribute("attribute.name.generic.illager_resistance", 0.0D, 0.0D, 10.0D)));

    public static Holder<Attribute> registerAttribute(String name, Attribute attribute) {
        return Registry.registerForHolder(BuiltInRegistries.ATTRIBUTE, Galosphere.id(name), attribute);
    }

    public static void init() {
    }

}
