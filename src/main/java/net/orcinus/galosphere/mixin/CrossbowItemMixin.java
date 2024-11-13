package net.orcinus.galosphere.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.level.Level;
import net.orcinus.galosphere.entities.GlowFlare;
import net.orcinus.galosphere.entities.SpectreFlare;
import net.orcinus.galosphere.init.GCriteriaTriggers;
import net.orcinus.galosphere.init.GItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {

    @Inject(at = @At("HEAD"), method = "createProjectile", cancellable = true)
    private void G$createProjectile(Level level, LivingEntity livingEntity, ItemStack itemStack, ItemStack itemStack2, boolean bl, CallbackInfoReturnable<Projectile> cir) {
        if (itemStack2.is(GItems.GLOW_FLARE)) {
            cir.setReturnValue(new GlowFlare(level, itemStack2, livingEntity, livingEntity.getX(), livingEntity.getEyeY() - (double) 0.15F, livingEntity.getZ(), true));
        } else if (itemStack2.is(GItems.SPECTRE_FLARE)) {
            cir.setReturnValue(new SpectreFlare(level, itemStack2, livingEntity, livingEntity.getX(), livingEntity.getEyeY() - (double) 0.15F, livingEntity.getZ(), true));
        }
    }

    @Inject(at = @At("HEAD"), method = "performShooting")
    private void G$performShooting(Level level, LivingEntity livingEntity, InteractionHand interactionHand, ItemStack itemStack, float f, float g, LivingEntity livingEntity2, CallbackInfo ci) {
        if (!(level instanceof ServerLevel)) return;

        ChargedProjectiles chargedProjectiles = itemStack.get(DataComponents.CHARGED_PROJECTILES);

        if (!(livingEntity instanceof ServerPlayer serverPlayer)) return;

        if (chargedProjectiles != null) {
            List<Item> list = chargedProjectiles.getItems().stream().map(ItemStack::getItem).toList();
            if (list.contains(GItems.GLOW_FLARE)) {
                GCriteriaTriggers.LIGHT_SPREAD.trigger(serverPlayer);
            } else if (list.contains(GItems.SPECTRE_FLARE)) {
                GCriteriaTriggers.USE_SPECTRE_FLARE.trigger(serverPlayer);
            }
        }
    }

}
