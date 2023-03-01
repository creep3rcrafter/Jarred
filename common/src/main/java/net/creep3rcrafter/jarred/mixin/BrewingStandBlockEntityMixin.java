package net.creep3rcrafter.jarred.mixin;

import net.minecraft.client.gui.screens.inventory.BrewingStandScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.inventory.BrewingStandMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandBlockEntity.class)
public abstract class BrewingStandBlockEntityMixin extends BaseContainerBlockEntity implements WorldlyContainer {

    protected BrewingStandBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Inject(method = "isBrewable", at = @At("HEAD"), cancellable = true)
    private static void inject1(NonNullList<ItemStack> nonNullList, CallbackInfoReturnable<Boolean> cir){
        ItemStack itemStack = (ItemStack)nonNullList.get(3);
        if (itemStack.isEmpty()) {
            cir.setReturnValue(false);
        } else if (!PotionBrewing.isIngredient(itemStack)) {
            cir.setReturnValue(false);
        }else {
            for(int i = 0; i < 3; ++i) {
                ItemStack itemStack2 = (ItemStack)nonNullList.get(i);
                if (!itemStack2.isEmpty() && PotionBrewing.hasMix(itemStack2, itemStack)) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
    @ModifyConstant(method = "serverTick", constant = @Constant(intValue = 400))
    private static int inject1(int val){
        return val + 400;
    }
}
