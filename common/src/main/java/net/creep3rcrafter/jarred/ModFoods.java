package net.creep3rcrafter.jarred;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHOCOLATE_MILK = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(2f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 1),0.5f).build();
}
