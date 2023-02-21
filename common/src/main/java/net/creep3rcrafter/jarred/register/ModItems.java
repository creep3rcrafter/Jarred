package net.creep3rcrafter.jarred.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.jarred.Jarred;
import net.creep3rcrafter.jarred.ModFoods;
import net.creep3rcrafter.jarred.item.FoodJarItem;
import net.creep3rcrafter.jarred.item.LiquidFoodJarItem;
import net.creep3rcrafter.jarred.item.MilkJarItem;
import net.creep3rcrafter.jarred.item.PotionJarItem;
import net.minecraft.core.Registry;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Jarred.MOD_ID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<Item> EMPTY_JAR = ITEMS.register("empty_jar", () ->
            new Item(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_BREWING)));
    public static final RegistrySupplier<Item> POTION_JAR = ITEMS.register("potion_jar", () ->
            new PotionJarItem(new Item.Properties().stacksTo(1).defaultDurability(3).tab(CreativeModeTab.TAB_BREWING)
                    .craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> COOKIE_JAR = ITEMS.register("cookie_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.COOKIE).craftRemainder(ModItems.EMPTY_JAR.get())));

    public static final RegistrySupplier<Item> SWEET_BERRY_JAR = ITEMS.register("sweet_berry_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.SWEET_BERRIES).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> GLOW_BERRY_JAR = ITEMS.register("glow_berry_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.GLOW_BERRIES).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> SWEET_BERRY_JELLY_JAR = ITEMS.register("sweet_berry_jelly_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.SWEET_BERRIES).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> GLOW_BERRY_JELLY_JAR = ITEMS.register("glow_berry_jelly_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.SWEET_BERRIES).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> APPLE_JAR = ITEMS.register("apple_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(4).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.APPLE).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> GOLDEN_APPLE_JAR = ITEMS.register("golden_apple_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(4).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.GOLDEN_APPLE).craftRemainder(ModItems.EMPTY_JAR.get())){
                @Override
                public Rarity getRarity(ItemStack itemStack) {
                    return Rarity.RARE;
                }
            });
    public static final RegistrySupplier<Item> ENCHANTED_GOLDEN_APPLE_JAR = ITEMS.register("enchanted_golden_apple_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(4).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.ENCHANTED_GOLDEN_APPLE).craftRemainder(ModItems.EMPTY_JAR.get())){
                @Override
                public boolean isFoil(ItemStack itemStack) {
                    return true;
                }
                @Override
                public Rarity getRarity(ItemStack itemStack) {
                    return Rarity.EPIC;
                }
            });
    public static final RegistrySupplier<Item> APPLE_SAUCE_JAR = ITEMS.register("apple_sauce_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(12).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.APPLE).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> GOLDEN_APPLE_SAUCE_JAR = ITEMS.register("golden_apple_sauce_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(12).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.GOLDEN_APPLE).craftRemainder(ModItems.EMPTY_JAR.get())){
                @Override
                public Rarity getRarity(ItemStack itemStack) {
                    return Rarity.RARE;
                }
            });
    public static final RegistrySupplier<Item> ENCHANTED_GOLDEN_APPLE_SAUCE_JAR = ITEMS.register("enchanted_golden_apple_sauce_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(12).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.ENCHANTED_GOLDEN_APPLE).craftRemainder(ModItems.EMPTY_JAR.get())){
                @Override
                public boolean isFoil(ItemStack itemStack) {
                    return true;
                }
                @Override
                public Rarity getRarity(ItemStack itemStack) {
                    return Rarity.EPIC;
                }
            });
    public static final RegistrySupplier<Item> APPLE_SLICES_JAR = ITEMS.register("apple_slices_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.APPLE).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> GOLDEN_APPLE_SLICES_JAR = ITEMS.register("golden_apple_slices_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.GOLDEN_APPLE).craftRemainder(ModItems.EMPTY_JAR.get())){
                @Override
                public Rarity getRarity(ItemStack itemStack) {
                    return Rarity.RARE;
                }
            });
    public static final RegistrySupplier<Item> ENCHANTED_GOLDEN_APPLE_SLICES_JAR = ITEMS.register("enchanted_golden_apple_slices_jar", () ->
            new FoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.ENCHANTED_GOLDEN_APPLE).craftRemainder(ModItems.EMPTY_JAR.get())){
                @Override
                public boolean isFoil(ItemStack itemStack) {
                    return true;
                }
                @Override
                public Rarity getRarity(ItemStack itemStack) {
                    return Rarity.EPIC;
                }
            });
    public static final RegistrySupplier<Item> MILK_JAR = ITEMS.register("milk_jar", () ->
            new MilkJarItem(new Item.Properties().stacksTo(1).defaultDurability(4).tab(CreativeModeTab.TAB_FOOD)
                    .craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> CHOCOLATE_MILK_JAR = ITEMS.register("chocolate_milk_jar", () ->
            new MilkJarItem(new Item.Properties().stacksTo(1).defaultDurability(4).tab(CreativeModeTab.TAB_FOOD)
                    .food(ModFoods.CHOCOLATE_MILK).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> HONEY_JAR = ITEMS.register("honey_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.HONEY_BOTTLE).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> BEETROOT_SOUP_JAR = ITEMS.register("beetroot_soup_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.BEETROOT_SOUP).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> SUSPICIOUS_STEW_JAR = ITEMS.register("suspicious_stew_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.SUSPICIOUS_STEW).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> MUSHROOM_STEW_JAR = ITEMS.register("mushroom_stew_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.MUSHROOM_STEW).craftRemainder(ModItems.EMPTY_JAR.get())));
    public static final RegistrySupplier<Item> RABBIT_STEW_JAR = ITEMS.register("rabbit_stew_jar", () ->
            new LiquidFoodJarItem(new Item.Properties().stacksTo(1).defaultDurability(8).tab(CreativeModeTab.TAB_FOOD)
                    .food(Foods.RABBIT_STEW).craftRemainder(ModItems.EMPTY_JAR.get())));

}
