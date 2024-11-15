package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.ai.sensing.TemptingSensor;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.entities.ai.SparkleAi;
import net.orcinus.galosphere.entities.ai.SpectreAi;
import net.orcinus.galosphere.entities.ai.sensors.BerserkerEntitySensor;
import net.orcinus.galosphere.entities.ai.sensors.NearestLichenMossSensor;
import net.orcinus.galosphere.entities.ai.sensors.NearestPollinatedClusterSensor;
import net.orcinus.galosphere.entities.ai.sensors.PreservedEntitySensor;

import java.util.function.Supplier;

public class GSensorTypes {

    public static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(Registries.SENSOR_TYPE, Galosphere.MODID);

    public static final Supplier<SensorType<TemptingSensor>> SPARKLE_TEMPTATIONS = SENSOR_TYPES.register("sparkle_temptations", () -> new SensorType<>(() -> new TemptingSensor(SparkleAi.getTemptations())));
    public static final Supplier<SensorType<TemptingSensor>> SPECTRE_TEMPTATIONS = SENSOR_TYPES.register("spectre_temptations", () -> new SensorType<>(() -> new TemptingSensor(SpectreAi.getTemptations())));
    public static final Supplier<SensorType<NearestPollinatedClusterSensor>> NEAREST_POLLINATED_CLUSTER = SENSOR_TYPES.register("nearest_pollinated_cluster", () -> new SensorType<>(NearestPollinatedClusterSensor::new));
    public static final Supplier<SensorType<NearestLichenMossSensor>> NEAREST_LICHEN_MOSS = SENSOR_TYPES.register("nearest_lichen_moss", () -> new SensorType<>(NearestLichenMossSensor::new));
    public static final Supplier<SensorType<BerserkerEntitySensor>> BLIGHTED_ENTITY_SENSOR = SENSOR_TYPES.register("blighted_entity_sensor", () -> new SensorType<>(BerserkerEntitySensor::new));
    public static final Supplier<SensorType<PreservedEntitySensor>> PRESERVED_ENTITY_SENSOR = SENSOR_TYPES.register("preserved_entity_sensor", () -> new SensorType<>(PreservedEntitySensor::new));

}