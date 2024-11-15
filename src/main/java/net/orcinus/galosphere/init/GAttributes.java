package net.orcinus.galosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;

public class GAttributes {
    public static final DeferredRegister<Attribute> ATTRIBTUES = DeferredRegister.create(Registries.ATTRIBUTE, Galosphere.MODID);

    public static final Holder<Attribute> ILLAGER_RESISTANCE = ATTRIBTUES.register("illager_resistance", () -> (new RangedAttribute("attribute.name.generic.illager_resistance", 0.0D, 0.0D, 10.0D)));

}
