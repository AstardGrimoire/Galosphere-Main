package net.orcinus.galosphere;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.orcinus.galosphere.config.GalosphereConfig;
import net.orcinus.galosphere.init.GAttributes;
import net.orcinus.galosphere.init.GBlockEntityTypes;
import net.orcinus.galosphere.init.GBlocks;
import net.orcinus.galosphere.init.GCreativeModeTabs;
import net.orcinus.galosphere.init.GCriteriaTriggers;
import net.orcinus.galosphere.init.GDataComponents;
import net.orcinus.galosphere.init.GEnchantmentEffectComponents;
import net.orcinus.galosphere.init.GEntityTypes;
import net.orcinus.galosphere.init.GFeatures;
import net.orcinus.galosphere.init.GItems;
import net.orcinus.galosphere.init.GLootModifiers;
import net.orcinus.galosphere.init.GMemoryModuleTypes;
import net.orcinus.galosphere.init.GMenuTypes;
import net.orcinus.galosphere.init.GMobEffects;
import net.orcinus.galosphere.init.GParticleTypes;
import net.orcinus.galosphere.init.GPlacedFeatures;
import net.orcinus.galosphere.init.GPotions;
import net.orcinus.galosphere.init.GRecipeSerializers;
import net.orcinus.galosphere.init.GSensorTypes;
import net.orcinus.galosphere.init.GSoundEvents;
import net.orcinus.galosphere.init.GStructureProcessorTypes;
import net.orcinus.galosphere.init.GVanillaIntegration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Galosphere.MODID)
public class Galosphere {
    
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "galosphere";

    public Galosphere(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        modContainer.registerConfig(ModConfig.Type.COMMON, GalosphereConfig.COMMON);

        GAttributes.ATTRIBTUES.register(modEventBus);
        GBlocks.BLOCKS.register(modEventBus);
        GBlockEntityTypes.BLOCK_ENTITIES.register(modEventBus);
        GCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        GCriteriaTriggers.CRITERION_TRIGGERS.register(modEventBus);
        GDataComponents.DATA_COMPONENT_TYPES.register(modEventBus);
        GEnchantmentEffectComponents.DATA_COMPONENTS.register(modEventBus);
        GEntityTypes.ENTITY_TYPES.register(modEventBus);
        GFeatures.FEATURES.register(modEventBus);
        GItems.ITEMS.register(modEventBus);
        GLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        GMemoryModuleTypes.MEMORY_MODULE_TYPES.register(modEventBus);
        GMenuTypes.MENU_TYPES.register(modEventBus);
        GMobEffects.MOB_EFFECTS.register(modEventBus);
        GPotions.POTIONS.register(modEventBus);
        GParticleTypes.PARTICLES.register(modEventBus);
        GRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
        GStructureProcessorTypes.STRUCTURE_PROCESSOR_TYPES.register(modEventBus);
        GSensorTypes.SENSOR_TYPES.register(modEventBus);
        GSoundEvents.SOUND_EVENTS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            GPlacedFeatures.init();
            GVanillaIntegration.init();
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(Galosphere.MODID, path);
    }

}
