package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.orcinus.galosphere.Galosphere;

public class GBlockTags {

    public static final TagKey<Block> GRAVEL_MAY_REPLACE = create("gravel_may_replace");
    public static final TagKey<Block> CRYSTAL_SPIKES_BLOCKS = create("crystal_spikes_blocks");
    public static final TagKey<Block> SPARKLES_SPAWNABLE_ON = create("sparkles_spawn_on");
    public static final TagKey<Block> SPECTRES_SPAWNABLE_ON = create("spectres_spawn_on");
    public static final TagKey<Block> OBFUSCATES_SOUND_WAVES = create("obfuscates_sound_waves");
    public static final TagKey<Block> PINK_SALT_BLOCKS = create("pink_salt_blocks");
    public static final TagKey<Block> PINK_SALT_HEATED_BLOCKS = create("pink_salt_heated_blocks");
    public static final TagKey<Block> OASIS_REPLACE = create("oasis_replace");
    public static final TagKey<Block> OASIS_GENERATE_ON = create("oasis_generate_on");
    public static final TagKey<Block> OMIT_ASTRAL = create("omit_astral");
    public static final TagKey<Block> CRYSTAL_CLUSTERS = create("crystal_clusters");
    public static final TagKey<Block> STONEFISH_PREFER_JUMP_TO = create("stonefish_prefer_jump_to");
    public static final TagKey<Block> CONVERT_STONE_STONEFISH = create("convert_stone_stonefish");
    public static final TagKey<Block> CONVERT_DRIPSTONE_STONEFISH = create("convert_dripstone_stonefish");
    public static final TagKey<Block> CONVERT_DEEPSLATE_STONEFISH = create("convert_deepslate_stonefish");

    private static TagKey<Block> create(String id) {
        return TagKey.create(Registries.BLOCK, Galosphere.id(id));
    }

}
