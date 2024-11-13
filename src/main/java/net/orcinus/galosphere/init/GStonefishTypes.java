package net.orcinus.galosphere.init;

import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.orcinus.galosphere.Galosphere;

import java.util.Map;

public class GStonefishTypes {
    public static final Map<String, StonefishType> STONEFISH_TYPES = Maps.newHashMap();

    public record StonefishType(String id, ResourceLocation texture, TagKey<Block> block) {
        public static final StonefishType DEFAULT = StonefishType.create("dripstone", Galosphere.id("textures/entity/stonefish/stonefish_dripstone.png"), GBlockTags.CONVERT_DRIPSTONE_STONEFISH);

        public static StonefishType create(String name, ResourceLocation texture, TagKey<Block> block) {
            return new StonefishType(name, texture, block);
        }

        public String get() {
            return this.id();
        }
    }

}
