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
public abstract class PotionSlotMixin extends Slot {
    public PotionSlotMixin(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }
    @Inject(method = "mayPlaceItem", at = @At("RETURN"), cancellable = true)
    private static void inject(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir){
        // && !itemStack.isDamaged()
        cir.setReturnValue(cir.getReturnValue() || (itemStack.is(ModItems.POTION_JAR.get())));
    }

}
