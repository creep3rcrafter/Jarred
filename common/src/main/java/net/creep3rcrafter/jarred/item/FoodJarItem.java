package net.creep3rcrafter.jarred.item;

import com.mojang.datafixers.util.Pair;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public class FoodJarItem extends Item {
    public FoodJarItem(Item.Properties properties) {
        super(properties);
    }

    public boolean isHoney(){
        return false;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
            player.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
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
            if (isHoney()){
                livingEntity.removeEffect(MobEffects.POISON);
            }
        }
        if (!player.getAbilities().instabuild) {
            if(itemStack.getDamageValue() < itemStack.getMaxDamage()-1){
                itemStack.setDamageValue(itemStack.getDamageValue()+1);
            }else{
                itemStack.shrink(1);
                ItemStack itemStack2 = new ItemStack(ModItems.EMPTY_JAR.get());
                if (!player.getInventory().add(itemStack2)) {
                    player.drop(itemStack2, false);
                }
            }
        }
        return itemStack;
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (isHoney()){
            return ItemUtils.startUsingInstantly(level, player, interactionHand);
        }else{
            return super.use(level, player, interactionHand);
        }
    }
}
