package net.creep3rcrafter.jarred.fabriclike;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.creep3rcrafter.jarred.BrewingRecipes;
import net.creep3rcrafter.jarred.Jarred;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.PotionBrewing;

import static net.creep3rcrafter.jarred.Jarred.MOD_ID;

public class JarredFabricLike {
    public static void init() {
        Jarred.init();
        new BrewingRecipes();
        ItemProperties.register(ModItems.POTION_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
    }
}
