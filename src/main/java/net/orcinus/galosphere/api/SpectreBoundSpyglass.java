package net.orcinus.galosphere.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.orcinus.galosphere.entities.Spectre;
import net.orcinus.galosphere.init.GDataComponents;
import net.orcinus.galosphere.init.GItems;

public interface SpectreBoundSpyglass {

    static boolean canUseSpectreBoundSpyglass(ItemStack stack) {
        return stack.is(GItems.SPECTRE_BOUND_SPYGLASS) && SpectreBoundSpyglass.isSpectreBoundSpyglass(stack);
    }

    static boolean isSpectreBoundSpyglass(ItemStack stack) {
        return stack.has(GDataComponents.SPECTRE_BOUND);
    }

    static void addSpectreBoundedTags(Spectre spectre, CompoundTag compoundTag) {
        compoundTag.putInt("SpectreBoundId", spectre.getId());
        compoundTag.putUUID("SpectreBoundUUID", spectre.getUUID());
    }

    boolean isUsingSpectreBoundedSpyglass();

    void setUsingSpectreBoundedSpyglass(boolean usingSpectreBoundedSpyglass);

}