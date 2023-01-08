package net.creep3rcrafter.jarred.mixin;

import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.PotionBrewing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionBrewing.class)
public abstract class PotionBrewingMixin {

    @Shadow
    public static void addContainer(Item arg) {
    }

    @Inject(method = "bootStrap()V", at = @At("HEAD"))
    private static void inject(CallbackInfo ci) {
        addContainer(item -> {
            return ModItems.POTION_JAR.get();
        });
    }
}
