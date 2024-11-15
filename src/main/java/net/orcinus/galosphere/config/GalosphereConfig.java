package net.orcinus.galosphere.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.orcinus.galosphere.Galosphere;

@EventBusSubscriber(modid = Galosphere.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GalosphereConfig {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static ModConfigSpec.BooleanValue SLOWED_BUDDING_AMETHYST_MINING_SPEED = BUILDER.comment("Slows the mining speed of budding amethyst").define("slowedBuddingAmethystMiningSpeed", true);;
    public static ModConfigSpec.BooleanValue SPECTRE_FLARE_ANCIENT_CITY_LOOT = BUILDER.comment("Adds spectre flares to ancient city loot").define("spectreFlareAncientCityLoot", true);;
    public static ModConfigSpec.BooleanValue SILVER_UPGRADE_TEMPLATES_LOOT = BUILDER.comment("Adds Silver Upgrade Template to Abandoned Mineshafts or Pillager Outposts loot").define("silverUpgradeTemplatesLoot", true);;

    public static ModConfigSpec COMMON = BUILDER.build();

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event) {
    }

}
