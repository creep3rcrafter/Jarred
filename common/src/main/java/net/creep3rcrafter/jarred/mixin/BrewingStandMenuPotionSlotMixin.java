package net.creep3rcrafter.jarred.mixin;

import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.inventory.BrewingStandMenu.PotionSlot.class)
public abstract class BrewingStandMenuPotionSlotMixin extends Slot {
    public BrewingStandMenuPotionSlotMixin(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }
    @Inject(method = "mayPlaceItem", at = @At("HEAD"), cancellable = true)
    private static void inject(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(itemStack.is(Items.POTION) || itemStack.is(Items.SPLASH_POTION) || itemStack.is(Items.LINGERING_POTION) || itemStack.is(Items.GLASS_BOTTLE)|| (itemStack.is(ModItems.POTION_JAR.get()) && !itemStack.isDamaged()));
    }

}
