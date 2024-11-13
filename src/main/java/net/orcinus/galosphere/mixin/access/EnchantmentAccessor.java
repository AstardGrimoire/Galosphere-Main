package net.orcinus.galosphere.mixin.access;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import java.util.function.Consumer;

@Mixin(Enchantment.class)
public interface EnchantmentAccessor {
    @Invoker
    static <T extends EnchantmentValueEffect> void callApplyEffects(List<ConditionalEffect<T>> list, LootContext lootContext, Consumer<T> consumer) {
        throw new UnsupportedOperationException();
    }

    @Invoker
    static LootContext callEntityContext(ServerLevel serverLevel, int i, Entity entity, Vec3 vec3) {
        throw new UnsupportedOperationException();
    }
}
