package net.orcinus.galosphere.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.orcinus.galosphere.init.GItems;
import org.jetbrains.annotations.NotNull;

public class PillagerSilverLootModifier extends LootModifier {
    public static final MapCodec<PillagerSilverLootModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance).and(instance.group(
            Codec.INT.fieldOf("min").forGetter(m -> m.min),
            Codec.INT.fieldOf("max").forGetter(m -> m.max)
    )).apply(instance, PillagerSilverLootModifier::new));

    private final int min;
    private final int max;

    public PillagerSilverLootModifier(LootItemCondition[] conditionsIn, int min, int max) {
        super(conditionsIn);
        this.min = min;
        this.max = max;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> objectArrayList, LootContext lootContext) {;
        HolderGetter<Enchantment> holderGetter = lootContext.getResolver().lookupOrThrow(Registries.ENCHANTMENT);
        Holder.Reference<Enchantment> enchantment = holderGetter.getOrThrow(Enchantments.UNBREAKING);

        Entity entity = lootContext.getParamOrNull(LootContextParams.ATTACKING_ENTITY);

        int lootingModifier = entity instanceof LivingEntity livingEntity ? EnchantmentHelper.getEnchantmentLevel(enchantment, livingEntity) : 0;
        int count = UniformInt.of(this.min, this.max).sample(lootContext.getRandom()) + lootingModifier;

        objectArrayList.add(new ItemStack(GItems.SILVER_NUGGET.get(), count));

        return objectArrayList;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
