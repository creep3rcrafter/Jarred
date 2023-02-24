package net.creep3rcrafter.jarred;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class ModFoods {
    public static final FoodProperties CHOCOLATE_MILK = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.8f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 1),1.0f).build();
    public static final FoodProperties SWEET_BERRY_JELLY = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties GLOW_BERRY_JELLY = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties APPLE_SAUCE = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties GOLDEN_APPLE_SAUCE = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(1f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100/4, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400/4, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties ENCHANTED_GOLDEN_APPLE_SAUCE = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(1f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 400/2, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000/3, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000/3, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400/2, 3), 1.0F).alwaysEat().build();
    public static final FoodProperties APPLE_SLICES = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.1f).build();
    public static final FoodProperties GOLDEN_APPLE_SLICES = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100/2, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400/6, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties ENCHANTED_GOLDEN_APPLE_SLICES = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 400/4, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000/6, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000/6, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400/6, 3), 1.0F).alwaysEat().build();


}
