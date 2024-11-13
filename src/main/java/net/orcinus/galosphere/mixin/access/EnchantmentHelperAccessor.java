package net.orcinus.galosphere.mixin.access;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EnchantmentHelper.class)
public interface EnchantmentHelperAccessor {
    @Invoker
    static void callRunIterationOnItem(ItemStack itemStack, EnchantmentHelper.EnchantmentVisitor enchantmentVisitor) {
        throw new UnsupportedOperationException();
    }
}
