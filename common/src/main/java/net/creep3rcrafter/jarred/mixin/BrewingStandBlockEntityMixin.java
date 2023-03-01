package net.creep3rcrafter.jarred.mixin;

import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandBlockEntity.class)
public abstract class BrewingStandBlockEntityMixin {
    @Inject(method = "isBrewable", at = @At("HEAD"), cancellable = true)
    private static void inject(NonNullList<ItemStack> nonNullList, CallbackInfoReturnable<Boolean> cir){
        ItemStack itemStack = (ItemStack)nonNullList.get(3);
        if (itemStack.isEmpty()) {
            System.out.println(1);
            cir.setReturnValue(false);
        } else if (!PotionBrewing.isIngredient(itemStack)) {
            System.out.println(2);
            cir.setReturnValue(false);
        } else {
            for(int i = 0; i < 3; ++i) {
                ItemStack itemStack2 = (ItemStack)nonNullList.get(i);
                if (!itemStack2.isEmpty() && PotionBrewing.hasMix(itemStack2, itemStack)) {
                    System.out.println(3);
                    cir.setReturnValue(true);
                }
            }
            System.out.println(4);
            cir.setReturnValue(false);
        }
    }
}
