package net.creep3rcrafter.jarred;

import net.creep3rcrafter.jarred.register.*;

public class Jarred {
    public static final String MOD_ID = "jarred";

    public static void init() {
        ModItems.ITEMS.register();
        //Items
        /*
        ItemPropertiesRegistry.register(ModItems.POTION_JAR::get, new ResourceLocation(MOD_ID, "fill"), (itemStack, level, livingEntity, i)->{
            return itemStack.getDamageValue();
        });
         */

    }
}
