package net.creep3rcrafter.jarred.quilt;

import net.creep3rcrafter.jarred.fabriclike.JarredFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class JarredQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        JarredFabricLike.init();
    }
}