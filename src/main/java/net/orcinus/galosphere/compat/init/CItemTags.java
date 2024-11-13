package net.orcinus.galosphere.compat.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CItemTags {

    public static final TagKey<Item> SILVER_BLOCKS = register("silver_blocks");
    public static final TagKey<Item> SILVER_INGOTS = register("silver_ingots");
    public static final TagKey<Item> SILVER_NUGGETS = register("silver_nuggets");
    public static final TagKey<Item> SILVER_ORES = register("silver_ores");

    private static TagKey<Item> register(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", name));
    }

}
