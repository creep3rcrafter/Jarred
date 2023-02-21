package net.creep3rcrafter.jarred.fabriclike;

import net.creep3rcrafter.jarred.BrewingRecipes;
import net.creep3rcrafter.jarred.Jarred;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

import static net.creep3rcrafter.jarred.Jarred.MOD_ID;

public class JarredFabricLike {
    public static void init() {
        Jarred.init();
        new BrewingRecipes();
        ItemProperties.register(ModItems.POTION_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.APPLE_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.APPLE_SLICES_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.APPLE_SAUCE_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.GOLDEN_APPLE_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.GOLDEN_APPLE_SAUCE_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.GOLDEN_APPLE_SLICES_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.ENCHANTED_GOLDEN_APPLE_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.ENCHANTED_GOLDEN_APPLE_SAUCE_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.ENCHANTED_GOLDEN_APPLE_SLICES_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.CHOCOLATE_MILK_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.MILK_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.SWEET_BERRY_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.SWEET_BERRY_JELLY_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.GLOW_BERRY_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.GLOW_BERRY_JELLY_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
    }
}
