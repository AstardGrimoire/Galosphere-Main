package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.world.gen.features.BerserkerFeature;
import net.orcinus.galosphere.world.gen.features.CrystalSpikeFeature;
import net.orcinus.galosphere.world.gen.features.LichenCordycepsColumnFeature;
import net.orcinus.galosphere.world.gen.features.LichenMushroomFeature;
import net.orcinus.galosphere.world.gen.features.LichenPatchFeature;
import net.orcinus.galosphere.world.gen.features.NoisePatchFeature;
import net.orcinus.galosphere.world.gen.features.OasisFeature;
import net.orcinus.galosphere.world.gen.features.PinkSaltStrawPatchFeature;
import net.orcinus.galosphere.world.gen.features.SimpleWaterloggedBlockFeature;
import net.orcinus.galosphere.world.gen.features.config.CrystalSpikeConfig;
import net.orcinus.galosphere.world.gen.features.config.NoisePatchConfig;
import net.orcinus.galosphere.world.gen.features.config.PinkSaltStrawPatchConfig;

import java.util.function.Supplier;

public class GFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Galosphere.MODID);

    public static final Supplier<Feature<CrystalSpikeConfig>> CRYSTAL_SPIKE = FEATURES.register("crystal_spike", () -> new CrystalSpikeFeature(CrystalSpikeConfig.CODEC));
    public static final Supplier<Feature<VegetationPatchConfiguration>> LICHEN_PATCH = FEATURES.register("lichen_patch", () -> new LichenPatchFeature(VegetationPatchConfiguration.CODEC));
    public static final Supplier<Feature<NoneFeatureConfiguration>> BOWL_LICHEN = FEATURES.register("bowl_lichen", () -> new LichenMushroomFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<Feature<NoneFeatureConfiguration>> LICHEN_CORDYCEPS_COLUMN = FEATURES.register("lichen_cordyceps_column", () -> new LichenCordycepsColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<Feature<NoisePatchConfig>> NOISE_PATCH = FEATURES.register("noise_patch", () -> new NoisePatchFeature(NoisePatchConfig.CODEC));
    public static final Supplier<Feature<PinkSaltStrawPatchConfig>> PINK_SALT_STRAW_PATCH = FEATURES.register("pink_salt_straw_patch", () -> new PinkSaltStrawPatchFeature(PinkSaltStrawPatchConfig.CODEC));
    public static final Supplier<Feature<NoneFeatureConfiguration>> OASIS = FEATURES.register("oasis", () -> new OasisFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<Feature<NoneFeatureConfiguration>> BERSERKER = FEATURES.register("berserker", () -> new BerserkerFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<Feature<SimpleBlockConfiguration>> SIMPLE_WATERLOGGED_BLOCK = FEATURES.register("simple_waterlogged_block", () -> new SimpleWaterloggedBlockFeature(SimpleBlockConfiguration.CODEC));

}
