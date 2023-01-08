package net.creep3rcrafter.jarred.register;

import dev.architectury.registry.registries.DeferredRegister;
import net.creep3rcrafter.jarred.Jarred;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Jarred.MOD_ID, Registry.MOB_EFFECT_REGISTRY);
}
