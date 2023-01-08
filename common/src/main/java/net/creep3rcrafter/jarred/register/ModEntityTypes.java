package net.creep3rcrafter.jarred.register;

import dev.architectury.registry.registries.DeferredRegister;
import net.creep3rcrafter.jarred.Jarred;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Jarred.MOD_ID, Registry.ENTITY_TYPE_REGISTRY);
}
