package net.creep3rcrafter.jarred;

import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.world.item.alchemy.PotionBrewing;

public class BrewingRecipes {
    public BrewingRecipes(){
        PotionBrewing.addContainer(ModItems.POTION_JAR.get());
    }
}
