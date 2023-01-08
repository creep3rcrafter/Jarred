package net.creep3rcrafter.jarred.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.*;

public class Utils {

    public static void lightning(BlockPos blockPos, ServerLevel level){
        LightningBolt LightningBolt = EntityType.LIGHTNING_BOLT.create(level);
        LightningBolt.moveTo(Vec3.atBottomCenterOf(blockPos));
        level.addFreshEntity(LightningBolt);
    }
    public static void lightning(BlockPos blockPos, ServerLevel level, LivingEntity livingEntity){
        LightningBolt LightningBolt = EntityType.LIGHTNING_BOLT.create(level);
        LightningBolt.moveTo(Vec3.atBottomCenterOf(blockPos));
        LightningBolt.setCause(livingEntity instanceof ServerPlayer ? (ServerPlayer) livingEntity : null);
        level.addFreshEntity(LightningBolt);
    }
    public static void lightning(LivingEntity livingEntity, ServerLevel level) {
        if (!livingEntity.isSpectator() && level != null) {
            BlockPos entityPos = livingEntity.blockPosition();
            lightning(entityPos, level, livingEntity);
        }
    }
    public static void lightning(LivingEntity livingEntity, ServerLevel level, int amplifier) {
        lightning(livingEntity, level);
        if (!livingEntity.isSpectator() && level != null) {
            for (int i = 0; i < amplifier; i++) {
                Random random = new Random();
                BlockPos entityPos = livingEntity.blockPosition();
                BlockPos blockPos = entityPos.offset(random.nextInt(amplifier) - (amplifier / 2), random.nextInt(amplifier) - (amplifier / 2), random.nextInt(amplifier) - (amplifier / 2));
                lightning(blockPos, level, livingEntity);
            }
        }
    }

    public static void explode(ServerLevel level, BlockPos blockPos) {
        explode(level, blockPos, 4f);
    }
    public static void explode(ServerLevel level, BlockPos blockPos, float radius) {
        explode(level, blockPos, radius, false);
    }
    public static void explode(ServerLevel level, BlockPos blockPos, float radius, boolean fire) {
        level.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), radius, fire, Explosion.BlockInteraction.BREAK);
    }

    public boolean hasServer(Level level){
        return level.getServer() != null;
    }
    public boolean hasServer(LivingEntity livingEntity){
        return livingEntity.getServer() != null;
    }

    public boolean tickTime(ServerLevel level, int ticks){
        return level.getServer().getTickCount() % ticks == 0;
    }
    public boolean tickTime(ServerPlayer serverPlayer, int ticks){
        return serverPlayer.getLevel().getServer().getTickCount() % ticks == 0;
    }
    public boolean tickTime(MinecraftServer server, int ticks){
        return server.getTickCount() % ticks == 0;
    }
    public boolean tickTime(LivingEntity livingEntity, int ticks){
        if (hasServer(livingEntity)){
            return tickTime(livingEntity.getServer(), ticks);
        }
        else{
            return false;
        }
    }

    public static int cropAgeToIndex(int age) {
        if (age > 6) {
            return 3;
        } else if (age > 3) {
            return 2;
        } else if (age > 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void dropXP(ServerLevel level, BlockPos blockPos) {
        int i = 3 + level.random.nextInt(5) + level.random.nextInt(5);
        while (i > 0) {
            int j = ExperienceOrb.getExperienceValue(i);
            i -= j;
            level.addFreshEntity(new ExperienceOrb(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), j));
        }
    }

    public int getDistanceToEntity(LivingEntity livingEntity, BlockPos pos) {
        double deltaX = livingEntity.getX() - pos.getX();
        double deltaY = livingEntity.getY() - pos.getY();
        double deltaZ = livingEntity.getZ() - pos.getZ();
        return (int) Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
    }

    public List<BlockPos> getNearbyBlockPostions(LivingEntity livingEntity, int radius) {
        List<BlockPos> blockPositions = new ArrayList<BlockPos>();
        for (int x = livingEntity.blockPosition().getX() - radius; x <= livingEntity.blockPosition().getX() + radius; x++) {
            for (int y = livingEntity.blockPosition().getY() - radius; y <= livingEntity.blockPosition().getY() + radius; y++) {
                for (int z = livingEntity.blockPosition().getZ() - radius; z <= livingEntity.blockPosition().getZ() + radius; z++) {
                    blockPositions.add(new BlockPos(x, y, z));
                }
            }
        }
        return blockPositions;
    }

    public static void damageItem(LivingEntity livingEntity, EquipmentSlot equipmentSlot, int damage) {
        if (livingEntity.getItemBySlot(equipmentSlot).isDamageableItem()) {
            //Item item = livingEntity.getItemBySlot(equipmentSlot).getItem();
            livingEntity.getItemBySlot(equipmentSlot).hurtAndBreak(damage, livingEntity, source -> {
                source.broadcastBreakEvent(equipmentSlot);
            });
        }
    }

    public static void damageItem(LivingEntity livingEntity, ItemStack itemStack, int damage) {
        if (itemStack.isDamageableItem()) {
            itemStack.hurtAndBreak(damage, livingEntity, source -> {
                source.broadcastBreakEvent(EquipmentSlot.CHEST);
            });
        }
    }
}
