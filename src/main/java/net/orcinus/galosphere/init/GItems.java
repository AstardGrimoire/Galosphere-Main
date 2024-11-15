package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.items.ChandelierItem;
import net.orcinus.galosphere.items.GlowFlareItem;
import net.orcinus.galosphere.items.GoldenLichenCordycepsItem;
import net.orcinus.galosphere.items.IconItem;
import net.orcinus.galosphere.items.LichenCordycepsItem;
import net.orcinus.galosphere.items.PreservedFleshItem;
import net.orcinus.galosphere.items.PreservedSmithingTemplateItem;
import net.orcinus.galosphere.items.SaltboundTabletItem;
import net.orcinus.galosphere.items.SilverBombItem;
import net.orcinus.galosphere.items.SilverSmithingTemplateItem;
import net.orcinus.galosphere.items.SpectreBottleItem;
import net.orcinus.galosphere.items.SpectreBoundSpyglassItem;
import net.orcinus.galosphere.items.SpectreFlareItem;
import net.orcinus.galosphere.items.SterlingArmorItem;

import java.util.function.Supplier;

public class GItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Galosphere.MODID);

    public static final Supplier<Item> ICON_ITEM = ITEMS.register("icon_item", () -> new IconItem(new Item.Properties().stacksTo(0)));

    public static final Supplier<Item> SPARKLE_SPAWN_EGG = ITEMS.register("sparkle_spawn_egg", () -> new DeferredSpawnEggItem(GEntityTypes.SPARKLE, 0xF0F5F4, 0x24F6D8, new Item.Properties()));
    public static final Supplier<Item> SPECTRE_SPAWN_EGG = ITEMS.register("spectre_spawn_egg", () -> new DeferredSpawnEggItem(GEntityTypes.SPECTRE, 0xFFF3DD, 0x9CCDB6, new Item.Properties()));
    public static final Supplier<Item> SPECTERPILLAR_SPAWN_EGG = ITEMS.register("specterpillar_spawn_egg", () -> new DeferredSpawnEggItem(GEntityTypes.SPECTERPILLAR, 0xFFF3DD, 0xF7CF7B, new Item.Properties()));
    public static final Supplier<Item> BERSERKER_SPAWN_EGG = ITEMS.register("berserker_spawn_egg", () -> new DeferredSpawnEggItem(GEntityTypes.BERSERKER, 15568753, 6057047, new Item.Properties()));
    public static final Supplier<Item> PRESERVED_SPAWN_EGG = ITEMS.register("preserved_spawn_egg", () -> new DeferredSpawnEggItem(GEntityTypes.PRESERVED, 15703431, 7246179, new Item.Properties()));
    public static final Supplier<Item> BOTTLE_OF_SPECTRE = ITEMS.register("bottle_of_spectre", () -> new SpectreBottleItem(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> ALLURITE_SHARD = registerBaseItem("allurite_shard");
    public static final Supplier<Item> LUMIERE_SHARD = registerBaseItem("lumiere_shard");
    public static final Supplier<Item> PINK_SALT_SHARD = registerBaseItem("pink_salt_shard");
    public static final Supplier<Item> RAW_SILVER = registerBaseItem("raw_silver");
    public static final Supplier<Item> SILVER_INGOT = registerBaseItem("silver_ingot");
    public static final Supplier<Item> SILVER_NUGGET = registerBaseItem("silver_nugget");
    public static final Supplier<Item> SILVER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("silver_upgrade_smithing_template", SilverSmithingTemplateItem::new);
    public static final Supplier<Item> BAROMETER = registerBaseItem("barometer");
    public static final Supplier<Item> SILVER_BOMB = ITEMS.register("silver_bomb", () -> new SilverBombItem(new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> STERLING_HELMET = ITEMS.register("sterling_helmet", () -> new SterlingArmorItem(ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STERLING_CHESTPLATE = ITEMS.register("sterling_chestplate", () -> new SterlingArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STERLING_LEGGINGS = ITEMS.register("sterling_leggings", () -> new SterlingArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STERLING_BOOTS = ITEMS.register("sterling_boots", () -> new SterlingArmorItem(ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STERLING_HORSE_ARMOR = ITEMS.register("sterling_horse_armor", () -> new AnimalArmorItem(GArmorMaterials.STERLING, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> SALTED_JERKY = ITEMS.register("salted_jerky", () -> new Item(new Item.Properties().food(GFoods.SALTED_JERKY)));
    public static final Supplier<Item> CURED_MEMBRANE = registerBaseItem("cured_membrane");
    public static final Supplier<Item> LICHEN_CORDYCEPS = ITEMS.register("lichen_cordyceps", () -> new LichenCordycepsItem(GBlocks.LICHEN_CORDYCEPS.get(), new Item.Properties().food(GFoods.LICHEN_CORDYCEPS)));
    public static final Supplier<Item> GOLDEN_LICHEN_CORDYCEPS = ITEMS.register("golden_lichen_cordyceps", () -> new GoldenLichenCordycepsItem(new Item.Properties().food(GFoods.GOLDEN_LICHEN_CORDYCEPS)));
    public static final Supplier<Item> GLOW_FLARE = ITEMS.register("glow_flare", () -> new GlowFlareItem(new Item.Properties()));
    public static final Supplier<Item> SPECTRE_FLARE = ITEMS.register("spectre_flare", () -> new SpectreFlareItem(new Item.Properties()));
    public static final Supplier<Item> SPECTRE_BOUND_SPYGLASS = ITEMS.register("spectre_bound_spyglass", () -> new SpectreBoundSpyglassItem(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> CHANDELIER = ITEMS.register("chandelier", () -> new ChandelierItem(GBlocks.CHANDELIER.get(), new Item.Properties()));

    public static final Supplier<Item> SALTBOUND_TABLET = ITEMS.register("saltbound_tablet", () -> new SaltboundTabletItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final Supplier<Item> PRESERVED_TEMPLATE = ITEMS.register("preserved_template", PreservedSmithingTemplateItem::new);
    public static final Supplier<Item> PRESERVED_FLESH = ITEMS.register("preserved_flesh", () -> new PreservedFleshItem(new Item.Properties().stacksTo(1).durability(180).food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.1f).build())));

    public static Supplier<Item> registerBaseItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

}
