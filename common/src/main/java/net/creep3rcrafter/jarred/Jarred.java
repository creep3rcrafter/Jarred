package net.creep3rcrafter.jarred;

import net.creep3rcrafter.jarred.register.*;
import net.minecraft.world.item.alchemy.PotionBrewing;

public class Jarred {
    public static final String MOD_ID = "jarred";

    public static void init() {
        ModItems.ITEMS.register();
        ModEffects.EFFECTS.register();
        ModBlocks.BLOCKS.register();
        ModFluids.FLUIDS.register();
        ModPotions.POTIONS.register();
        ModEntityTypes.ENTITY_TYPES.register();
        ModRecipeTypes.RECIPE_TYPES.register();
        /*
        ItemPropertiesRegistry.register(ModItems.POTION_JAR::get, new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
         */
        //Items
    }
}
