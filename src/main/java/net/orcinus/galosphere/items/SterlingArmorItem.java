package net.orcinus.galosphere.items;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.init.GArmorMaterials;
import net.orcinus.galosphere.init.GAttributes;

import java.util.function.Supplier;

public class SterlingArmorItem extends ArmorItem {
    private final Supplier<ItemAttributeModifiers> itemAttributeModifiersSupplier;

    public SterlingArmorItem(Type type, Properties properties) {
        super(GArmorMaterials.STERLING, type, properties);
        this.itemAttributeModifiersSupplier = Suppliers.memoize(() -> {
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
            EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
            ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace("armor." + type.getName());
            ResourceLocation gResourceLocation = Galosphere.id("armor." + type.getName());
            builder.add(Attributes.ARMOR, new AttributeModifier(resourceLocation, this.getMaterial().value().getDefense(type), AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourceLocation, this.getMaterial().value().toughness(), AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            builder.add(GAttributes.ILLAGER_RESISTANCE, new AttributeModifier(gResourceLocation, this.getIllagerResistance(type.getSlot()), AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            return builder.build();
        });
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.itemAttributeModifiersSupplier.get();
    }

    public float getIllagerResistance(EquipmentSlot slot) {
        float[] array = new float[]{3, 5, 6, 2};
        return array[slot.getIndex()];
    }

}
