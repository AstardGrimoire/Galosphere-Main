package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.orcinus.galosphere.Galosphere;
import org.jetbrains.annotations.NotNull;

public class GBiomeTags {

    public static final TagKey<Biome> HAS_PINK_SALT_SHRINE = create("has_structure/pink_salt_shrine");
    public static final TagKey<Biome> HAS_FORGOTTEN_TOMBS = create("has_structure/forgotten_tombs");

    @NotNull
    private static TagKey<Biome> create(String path) {
        return TagKey.create(Registries.BIOME, Galosphere.id(path));
    }

}
