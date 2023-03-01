package net.creep3rcrafter.jarred.mixin;

import net.minecraft.client.gui.screens.inventory.BrewingStandScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(BrewingStandScreen.class)
public abstract class BrewingStandScreenMixin{

    @ModifyConstant(method = "renderBg", constant = @Constant(floatValue = 400.0f))
    private static float inject1(float val){
        return val + 400.0f;
    }
}//make dynamic for bottles and jars
//fix potions being still brewable when jars have max potions
