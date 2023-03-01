package net.creep3rcrafter.jarred.mixin;

import net.creep3rcrafter.jarred.item.PotionJarItem;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(PotionBrewing.class)
public abstract class PotionBrewingMixin {

    @Inject(method = "hasMix", at = @At("HEAD"), cancellable = true)
    private static void inject1(ItemStack containerItemStack, ItemStack ingredientItemStack, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("hasMixTest");
        if (containerItemStack.is(ModItems.POTION_JAR.get())){
            if (ingredientItemStack.is(Items.POTION)){
                System.out.println("hasMix");
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method = "isIngredient", at = @At("HEAD"), cancellable = true)
    private static void inject2(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.is(Items.POTION)){
            if ((PotionUtils.getMobEffects(itemStack)).size() > 0){
                System.out.println("isIngredient");
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method = "mix", at = @At("HEAD"), cancellable = true)
    private static void inject3(ItemStack itemStack, ItemStack itemStack2, CallbackInfoReturnable<ItemStack> cir) {
        if (!itemStack2.isEmpty()){
            if (itemStack.getItem() instanceof PotionItem){
                if (itemStack2.getItem() instanceof PotionJarItem){
                    List<MobEffectInstance> ingredientMobEffectInstances = new ArrayList<>();
                    ingredientMobEffectInstances.addAll(PotionUtils.getMobEffects(itemStack));
                    ingredientMobEffectInstances.addAll(PotionUtils.getCustomEffects(itemStack));
                    List<MobEffectInstance> baseMobEffectInstances = new ArrayList<>();
                    baseMobEffectInstances.addAll(PotionUtils.getMobEffects(itemStack2));
                    baseMobEffectInstances.addAll(PotionUtils.getCustomEffects(itemStack2));
                    List<MobEffectInstance> totalMobEffectInstances = new ArrayList<>();
                    totalMobEffectInstances.addAll(PotionUtils.getMobEffects(itemStack));
                    totalMobEffectInstances.addAll(PotionUtils.getCustomEffects(itemStack2));
                    totalMobEffectInstances.addAll(PotionUtils.getCustomEffects(itemStack));
                    List<MobEffect> baseMobEffects = new ArrayList<>();
                    for (MobEffectInstance mobEffectInstance : baseMobEffectInstances){
                        baseMobEffects.add(mobEffectInstance.getEffect());
                    }
                    List<MobEffect> ingredientMobEffects = new ArrayList<>();
                    for (MobEffectInstance mobEffectInstance : ingredientMobEffectInstances){
                        ingredientMobEffects.add(mobEffectInstance.getEffect());
                    }

                    if (!(baseMobEffects.containsAll(ingredientMobEffects))){
                        if ((baseMobEffects.size() + ingredientMobEffects.size()) <= 4){
                            PotionUtils.setCustomEffects(itemStack2, totalMobEffectInstances);
                            System.out.println("Brewed");
                            cir.setReturnValue(itemStack2);
                        }
                    }
                }
            }
        }
    }
}
