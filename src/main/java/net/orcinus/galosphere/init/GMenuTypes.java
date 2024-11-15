package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.client.gui.CombustionTableMenu;

import java.util.function.Supplier;

public class GMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, Galosphere.MODID);

    public static final Supplier<MenuType<CombustionTableMenu>> COMBUSTION_TABLE = MENU_TYPES.register("combustion_table", () -> new MenuType<>(CombustionTableMenu::new, FeatureFlags.VANILLA_SET));

}