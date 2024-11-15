package net.orcinus.galosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.crafting.PreservedTransformRecipe;

import java.util.function.Supplier;

public class GRecipeSerializers {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Galosphere.MODID);

    public static final Supplier<RecipeSerializer<PreservedTransformRecipe>> PRESERVED_TRANSFORM = RECIPE_SERIALIZERS.register("preserved_transform_recipe", PreservedTransformRecipe.Serializer::new);

}
