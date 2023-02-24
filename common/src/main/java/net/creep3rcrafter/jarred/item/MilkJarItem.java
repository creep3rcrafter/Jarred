package net.creep3rcrafter.jarred.item;

import com.mojang.datafixers.util.Pair;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MilkJarItem extends FoodJarItem {
    private static final int DRINK_DURATION = 32;
    public MilkJarItem(Properties properties) {
        super(properties);
    }
    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        if (!level.isClientSide) {
            livingEntity.removeAllEffects();
            if (itemStack.isEdible()) {
                level.playSound((Player)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), this.getEatingSound(), SoundSource.NEUTRAL, 1.0F, 1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
                List<Pair<MobEffectInstance, Float>> list = this.getFoodProperties().getEffects();

                for (Pair<MobEffectInstance, Float> mobEffectInstanceFloatPair : list) {
                    Pair<MobEffectInstance, Float> pair = (Pair) mobEffectInstanceFloatPair;
                    if (pair.getFirst() != null && level.random.nextFloat() < (Float) pair.getSecond()) {
                        livingEntity.addEffect(new MobEffectInstance((MobEffectInstance) pair.getFirst()));
                    }
                }
                livingEntity.gameEvent(GameEvent.EAT);
                player.getFoodData().eat(getFoodProperties().getNutrition(), getFoodProperties().getSaturationModifier());
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                if(itemStack.getDamageValue() < itemStack.getMaxDamage()-1){
                    itemStack.setDamageValue(itemStack.getDamageValue()+1);
                }else{
                    itemStack.shrink(1);
                    player.getInventory().add(new ItemStack(ModItems.EMPTY_JAR.get()));
                }
            }
        }
        return itemStack;
    }
    @Override
    public @NotNull SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 32;
    }
    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return ItemUtils.startUsingInstantly(level, player, interactionHand);
    }
}
