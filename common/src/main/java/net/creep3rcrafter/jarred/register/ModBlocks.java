package net.creep3rcrafter.jarred.register;

import dev.architectury.registry.registries.DeferredRegister;
import net.creep3rcrafter.jarred.Jarred;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Jarred.MOD_ID, Registry.BLOCK_REGISTRY);
}
