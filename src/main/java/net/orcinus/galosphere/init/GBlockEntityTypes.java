package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.blocks.blockentities.CordycepsBlockEntity;
import net.orcinus.galosphere.blocks.blockentities.GildedBeadsBlockEntity;
import net.orcinus.galosphere.blocks.blockentities.GlowInkClumpsBlockEntity;
import net.orcinus.galosphere.blocks.blockentities.MonstrometerBlockEntity;
import net.orcinus.galosphere.blocks.blockentities.PinkSaltChamberBlockEntity;
import net.orcinus.galosphere.blocks.blockentities.ShadowFrameBlockEntity;

import java.util.function.Supplier;

public class GBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Galosphere.MODID);

    public static final Supplier<BlockEntityType<MonstrometerBlockEntity>> MONSTROMETER = BLOCK_ENTITIES.register("monstrometer", () -> BlockEntityType.Builder.of(MonstrometerBlockEntity::new, GBlocks.MONSTROMETER.get()).build(null));
    public static final Supplier<BlockEntityType<GlowInkClumpsBlockEntity>> GLOW_INK_CLUMPS = BLOCK_ENTITIES.register("glow_ink_clumps", () -> BlockEntityType.Builder.of(GlowInkClumpsBlockEntity::new, GBlocks.GLOW_INK_CLUMPS.get()).build(null));
    public static final Supplier<BlockEntityType<CordycepsBlockEntity>> CORDYCEPS = BLOCK_ENTITIES.register("cordyceps", () -> BlockEntityType.Builder.of(CordycepsBlockEntity::new, GBlocks.LICHEN_CORDYCEPS.get()).build(null));
    public static final Supplier<BlockEntityType<ShadowFrameBlockEntity>> SHADOW_FRAME = BLOCK_ENTITIES.register("shadow_frame", () -> BlockEntityType.Builder.of(ShadowFrameBlockEntity::new, GBlocks.SHADOW_FRAME.get()).build(null));
    public static final Supplier<BlockEntityType<GildedBeadsBlockEntity>> GILDED_BEADS = BLOCK_ENTITIES.register("gilded_beads", () -> BlockEntityType.Builder.of(GildedBeadsBlockEntity::new, GBlocks.GILDED_BEADS.get()).build(null));
    public static final Supplier<BlockEntityType<PinkSaltChamberBlockEntity>> PINK_SALT_CHAMBER = BLOCK_ENTITIES.register("pink_salt_chamber", () -> BlockEntityType.Builder.of(PinkSaltChamberBlockEntity::new, GBlocks.PINK_SALT_CHAMBER.get()).build(null));

}



