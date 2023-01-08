package net.creep3rcrafter.jarred.register;

import dev.architectury.registry.registries.DeferredRegister;
import net.creep3rcrafter.jarred.Jarred;
import net.minecraft.core.Registry;
import net.minecraft.world.level.material.Fluid;
public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Jarred.MOD_ID, Registry.FLUID_REGISTRY);
}
