package net.orcinus.galosphere.util;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.orcinus.galosphere.init.GEnchantmentEffectComponents;
import net.orcinus.galosphere.mixin.access.EnchantmentAccessor;
import net.orcinus.galosphere.mixin.access.EnchantmentHelperAccessor;
import org.apache.commons.lang3.mutable.MutableFloat;

import java.util.List;

public class GEnchantmentHelper {

    public static int hasEnfeeble(ServerLevel serverLevel, ItemStack itemStack, Entity entity) {
        MutableFloat mutableFloat = new MutableFloat(0.0f);
        EnchantmentHelperAccessor.callRunIterationOnItem(itemStack, (holder, i) -> addEffects(holder.value(), serverLevel, i, itemStack, entity, mutableFloat, GEnchantmentEffectComponents.SALTBOUND_TABLET_DECELERATION));
        return Math.max(0, mutableFloat.intValue());
    }

    public static int hasRupture(ServerLevel serverLevel, ItemStack itemStack, Entity entity) {
        MutableFloat mutableFloat = new MutableFloat(0.0f);
        EnchantmentHelperAccessor.callRunIterationOnItem(itemStack, (holder, i) -> addEffects(holder.value(), serverLevel, i, itemStack, entity, mutableFloat, GEnchantmentEffectComponents.SALTBOUND_TABLET_RUPTURE));
        return Math.max(0, mutableFloat.intValue());
    }

    public static int getSustainingTicks(ServerLevel serverLevel, ItemStack itemStack, Entity entity) {
        MutableFloat mutableFloat = new MutableFloat(0.0f);
        EnchantmentHelperAccessor.callRunIterationOnItem(itemStack, (holder, i) -> addEffects(holder.value(), serverLevel, i, itemStack, entity, mutableFloat, GEnchantmentEffectComponents.SALTBOUND_TABLET_SUSTAIN));
        return Math.max(0, mutableFloat.intValue());
    }

    public static void addEffects(Enchantment enchantment, ServerLevel serverLevel, int i, ItemStack itemStack, Entity entity, MutableFloat mutableFloat, DataComponentType<List<ConditionalEffect<EnchantmentValueEffect>>> type) {
        EnchantmentAccessor.callApplyEffects(enchantment.getEffects(type), EnchantmentAccessor.callEntityContext(serverLevel, i, entity, entity.position()), enchantmentValueEffect -> mutableFloat.setValue(enchantmentValueEffect.process(i, entity.getRandom(), mutableFloat.floatValue())));
    }

}
