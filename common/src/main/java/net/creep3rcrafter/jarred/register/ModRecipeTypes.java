package net.creep3rcrafter.jarred.register;

import dev.architectury.registry.registries.DeferredRegister;
import net.creep3rcrafter.jarred.Jarred;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Jarred.MOD_ID, Registry.RECIPE_TYPE_REGISTRY);
}
