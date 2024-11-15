package net.orcinus.galosphere.events;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.ProjectileDispenseBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.api.BannerAttachable;
import net.orcinus.galosphere.blocks.LumiereComposterBlock;
import net.orcinus.galosphere.config.GalosphereConfig;
import net.orcinus.galosphere.crafting.LumiereComposterDispenseItemBehavior;
import net.orcinus.galosphere.crafting.LumiereReformingManager;
import net.orcinus.galosphere.crafting.MonstrometerDispenseItemBehavior;
import net.orcinus.galosphere.crafting.PickaxeDispenseItemBehavior;
import net.orcinus.galosphere.crafting.WarpedAnchorDispenseItemBehavior;
import net.orcinus.galosphere.init.GBlocks;
import net.orcinus.galosphere.init.GItems;
import net.orcinus.galosphere.init.GPotions;
import net.orcinus.galosphere.init.GSoundEvents;
import net.orcinus.galosphere.mixin.access.LootTableAccessor;
import net.orcinus.galosphere.network.BarometerPacket;
import net.orcinus.galosphere.util.BannerRendererUtil;

import java.util.List;

@EventBusSubscriber(modid = Galosphere.MODID, bus = EventBusSubscriber.Bus.GAME)
public class MiscEvents {

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();
        builder.addMix(Potions.AWKWARD, GItems.CURED_MEMBRANE.get(), GPotions.ASTRAL);
        builder.addMix(GPotions.ASTRAL, Items.REDSTONE, GPotions.LONG_ASTRAL);
    }

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation name = event.getName();
        LootTable table = event.getTable();
        List<LootPool> pools = ((LootTableAccessor)table).getPools();
        if (name.equals(BuiltInLootTables.ANCIENT_CITY.location()) && GalosphereConfig.SPECTRE_FLARE_ANCIENT_CITY_LOOT.get()) {
            pools.add(LootPool.lootPool().add(LootItem.lootTableItem(GItems.SPECTRE_FLARE.get()).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))).build());
        }
        if ((name.equals(BuiltInLootTables.PILLAGER_OUTPOST.location()) || name.equals(BuiltInLootTables.ABANDONED_MINESHAFT.location())) && GalosphereConfig.SILVER_UPGRADE_TEMPLATES_LOOT.get()) {
            pools.add(LootPool.lootPool().add(LootItem.lootTableItem(GItems.SILVER_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))).build());
        }
    }

    @SubscribeEvent
    public static void onWorldTick(LevelTickEvent.Pre event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getPlayers(serverPlayer -> true).forEach(serverPlayer -> {
                ServerLevelData levelData = (ServerLevelData) serverLevel.getLevelData();
                int rainTime = levelData.getClearWeatherTime() > 0 ? levelData.getClearWeatherTime() : levelData.getRainTime();
                int i = rainTime;
                PacketDistributor.sendToPlayer(serverPlayer, new BarometerPacket(i));
            });
        }
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        BlockPos pos = event.getPos();
        Level world = event.getLevel();
        BlockState state = world.getBlockState(pos);
        if (player.isShiftKeyDown() && !((BannerAttachable) player).getBanner().isEmpty() && stack.isEmpty()) {
            ItemStack copy = ((BannerAttachable) player).getBanner();
            player.setItemInHand(hand, copy);
            player.gameEvent(GameEvent.EQUIP, player);
            ((BannerAttachable) player).setBanner(ItemStack.EMPTY);
        }
        if (state.getBlock() == Blocks.COMPOSTER) {
            if (stack.getItem() == GItems.LUMIERE_SHARD.get()) {
                if (state.getValue(ComposterBlock.LEVEL) > 0 && state.getValue(ComposterBlock.LEVEL) < 8) {
                    event.setCanceled(true);
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                    world.setBlock(pos, GBlocks.LUMIERE_COMPOSTER.get().defaultBlockState().setValue(LumiereComposterBlock.LEVEL, state.getValue(ComposterBlock.LEVEL)), 2);
                    world.playSound(null, pos, GSoundEvents.LUMIERE_COMPOST.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                    player.swing(hand);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        ItemStack stack = event.getItemStack();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        Level world = event.getLevel();
        BannerRendererUtil util = new BannerRendererUtil();
        if (((BannerAttachable) player).getBanner().isEmpty() && player.getItemBySlot(EquipmentSlot.HEAD).is(GItems.STERLING_HELMET.get())) {
            if (util.isTapestryStack(stack) || stack.getItem() instanceof BannerItem) {
                player.gameEvent(GameEvent.EQUIP, player);
                ItemStack copy = stack.copy();
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                copy.setCount(1);
                ((BannerAttachable) player).setBanner(copy);
                player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER.value(), 1.0F, 1.0F);
                player.swing(hand);
            }
        }
    }

    @SubscribeEvent
    public static void onTagsUpdated(TagsUpdatedEvent event) {
        DispenserBlock.registerBehavior(GBlocks.ALLURITE_BLOCK.get().asItem(), new MonstrometerDispenseItemBehavior());
        DispenserBlock.registerBehavior(GBlocks.ALLURITE_BLOCK.get().asItem(), new WarpedAnchorDispenseItemBehavior());
        DispenserBlock.registerBehavior(GItems.LUMIERE_SHARD.get(), new LumiereComposterDispenseItemBehavior());
        DispenserBlock.registerBehavior(GItems.GLOW_FLARE.get(), new ProjectileDispenseBehavior(GItems.GLOW_FLARE.get()));
        BuiltInRegistries.ITEM.getTagOrEmpty(ItemTags.CLUSTER_MAX_HARVESTABLES).iterator().forEachRemaining(holder -> {
            DispenserBlock.registerBehavior(holder.value(), new PickaxeDispenseItemBehavior());
        });

    }

}
