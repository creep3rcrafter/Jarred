package net.creep3rcrafter.jarred.fabric;

import net.creep3rcrafter.jarred.fabriclike.JarredFabricLike;
import net.fabricmc.api.ModInitializer;

public class JarredFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        JarredFabricLike.init();
    }
}
