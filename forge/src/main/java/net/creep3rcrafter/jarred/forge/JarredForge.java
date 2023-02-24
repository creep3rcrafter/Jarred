package net.creep3rcrafter.jarred.forge;

import dev.architectury.platform.forge.EventBuses;
import net.creep3rcrafter.jarred.BrewingRecipes;
import net.creep3rcrafter.jarred.Jarred;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static net.creep3rcrafter.jarred.Jarred.MOD_ID;

@Mod(MOD_ID)
public class JarredForge {
    public JarredForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(MOD_ID, eventBus);
        Jarred.init();
        eventBus.addListener(this::commonSetupEvent);
    }

    private void commonSetupEvent(FMLCommonSetupEvent event){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(new BrewingRecipes());
        ItemProperties.register(ModItems.POTION_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        ItemProperties.register(ModItems.COOKIE_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
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
        ItemProperties.register(ModItems.HONEY_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
    }
}
