package net.creep3rcrafter.jarred.fabriclike;

import net.creep3rcrafter.jarred.Jarred;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.world.item.alchemy.PotionBrewing;

public class JarredFabricLike {
    public static void init() {
        Jarred.init();
        //PotionBrewing.ALLOWED_CONTAINERS.add(Ingredient.of(new ItemLike[]{ModItems.POTION_JAR.get()}));
        PotionBrewing.addContainer(ModItems.POTION_JAR.get());
        //new BrewingRecipes(); //example
    }
}
