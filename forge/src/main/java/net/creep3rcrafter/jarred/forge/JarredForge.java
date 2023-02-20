package net.creep3rcrafter.jarred.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.creep3rcrafter.jarred.BrewingRecipes;
import net.creep3rcrafter.jarred.Jarred;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.client.gui.screens.inventory.BrewingStandScreen;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
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
        ItemProperties.register(ModItems.POTION_JAR.get(), new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
        eventBus.register(new BrewingRecipes());
    }
}
