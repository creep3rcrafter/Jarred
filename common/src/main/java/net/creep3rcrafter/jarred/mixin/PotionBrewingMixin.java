package net.creep3rcrafter.jarred.mixin;

import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(PotionBrewing.class)
public abstract class PotionBrewingMixin {

    @Shadow
    public static void addContainer(Item arg) {
    }

    @Inject(method = "bootStrap()V", at = @At("HEAD"))
    private static void inject(CallbackInfo ci) {
<<<<<<< Updated upstream
        //addContainer(ModItems.POTION_JAR.get());
=======
        /*
        addContainer(item -> {
            return ModItems.POTION_JAR.get();
        });
         */
>>>>>>> Stashed changes
    }
}
