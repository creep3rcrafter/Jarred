package net.creep3rcrafter.jarred.item;

import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class EmptyJarItem extends Item {
    public EmptyJarItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemStack);
        } else {
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = hitResult.getBlockPos();
                BlockState blockState = level.getBlockState(blockPos);
                if (blockState.hasProperty(BeehiveBlock.HONEY_LEVEL)){
                    if (blockState.getValue(BeehiveBlock.HONEY_LEVEL) >= 5){
                        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                        level.setBlock(blockPos, blockState.setValue(BeehiveBlock.HONEY_LEVEL, 0), 3);
                        return InteractionResultHolder.sidedSuccess(this.turnJarIntoItem(itemStack, player, new ItemStack(ModItems.HONEY_JAR.get())), level.isClientSide());
                    }
                }
                if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
                    level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    level.gameEvent(player, GameEvent.FLUID_PICKUP, blockPos);
                    return InteractionResultHolder.sidedSuccess(this.turnJarIntoItem(itemStack, player, PotionUtils.setPotion(new ItemStack(ModItems.POTION_JAR.get()), Potions.WATER)), level.isClientSide());
                }
            }

            return InteractionResultHolder.pass(itemStack);
        }
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity instanceof MushroomCow && !livingEntity.isBaby()){
            ItemStack itemStack2 =  new ItemStack(ModItems.MUSHROOM_STEW_JAR.get());
            MobEffect effect = ((MushroomCow)livingEntity).effect;
            int effectDuration = ((MushroomCow)livingEntity).effectDuration;
            SuspiciousStewItem.saveMobEffect(itemStack2, effect, effectDuration);
            this.turnJarIntoItem(itemStack, player,itemStack2);
            return InteractionResult.sidedSuccess(player.level.isClientSide());
        }
        if (livingEntity instanceof Cow && !livingEntity.isBaby()){
            this.turnJarIntoItem(itemStack, player, new ItemStack(ModItems.MILK_JAR.get()));
            return InteractionResult.sidedSuccess(player.level.isClientSide());
        }
        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }

    protected ItemStack turnJarIntoItem(ItemStack itemStack, Player player, ItemStack itemStack2) {
        player.awardStat(Stats.ITEM_USED.get(this));
        return ItemUtils.createFilledResult(itemStack, player, itemStack2);
    }
}
