package net.creep3rcrafter.jarred.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.jarred.Jarred;
import net.creep3rcrafter.jarred.item.FoodJarItem;
import net.creep3rcrafter.jarred.item.PotionJarItem;
import net.minecraft.core.Registry;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Jarred.MOD_ID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<Item> EMPTY_JAR = ITEMS.register("empty_jar", () ->
            new Item(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_BREWING)));
    public static final RegistrySupplier<Item> POTION_JAR = ITEMS.register("potion_jar", () -> new PotionJarItem(new Item.Properties().stacksTo(1).defaultDurability(3).tab(CreativeModeTab.TAB_BREWING)));
    public static final RegistrySupplier<Item> COOKIE_JAR = ITEMS.register("cookie_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(16).tab(CreativeModeTab.TAB_FOOD).food(Foods.COOKIE)));
    public static final RegistrySupplier<Item> BERRY_JAR = ITEMS.register("berry_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(16).tab(CreativeModeTab.TAB_FOOD).food(Foods.SWEET_BERRIES)));
    public static final RegistrySupplier<Item> GOLDEN_APPLE_JAR = ITEMS.register("golden_apple_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(4).tab(CreativeModeTab.TAB_FOOD).food(Foods.GOLDEN_APPLE)));


}
