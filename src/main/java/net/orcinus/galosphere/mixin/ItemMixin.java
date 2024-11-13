package net.orcinus.galosphere.mixin;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.orcinus.galosphere.init.GDataComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public class ItemMixin {
    
    @Inject(at = @At("HEAD"), method = "appendHoverText")
    private void G$appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag, CallbackInfo ci) {
        if (itemStack.has(GDataComponents.PRESERVED)) {
            list.add(Component.translatable("item.galosphere.preserved").withStyle(ChatFormatting.DARK_PURPLE));
        }
    }
    
}
