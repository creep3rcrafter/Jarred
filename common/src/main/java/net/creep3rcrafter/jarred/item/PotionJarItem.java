package net.creep3rcrafter.jarred.item;

import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PotionJarItem extends PotionItem {
    public PotionJarItem(Item.Properties properties) {
        super(properties);
    }
    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        if (!level.isClientSide) {
            List<MobEffectInstance> list = PotionUtils.getMobEffects(itemStack);

            for (MobEffectInstance mobEffectInstance : list) {
                if (mobEffectInstance.getEffect().isInstantenous()) {
                    mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobEffectInstance.getAmplifier(), 1.0);
                } else {
                    livingEntity.addEffect(new MobEffectInstance(mobEffectInstance));
                }
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

        livingEntity.gameEvent(GameEvent.DRINK);
        return itemStack;
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab creativeModeTab, @NotNull NonNullList<ItemStack> nonNullList) {
        if (this.allowedIn(creativeModeTab)) {
            for (Potion potion : Registry.POTION) {
                if (potion != Potions.EMPTY) {
                    nonNullList.add(PotionUtils.setPotion(new ItemStack(this), potion));
                    ColorHandlerRegistry.registerItemColors(new ItemColor() {
                        @Override
                        public int getColor(@NotNull ItemStack itemStack, int i) {
                            return i == 0 ? PotionUtils.getColor(itemStack) : -1;
                        }
                    }, ModItems.POTION_JAR.get());
                }
            }
        }
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack itemStack) {
        StringBuilder potionID;
        if (PotionUtils.getCustomEffects(itemStack).size() > 0){
            List<MobEffectInstance> mobEffectInstances = new ArrayList<>();
            mobEffectInstances.addAll(PotionUtils.getMobEffects(itemStack));
            mobEffectInstances.addAll(PotionUtils.getCustomEffects(itemStack));
            potionID = new StringBuilder();
            if (mobEffectInstances.size() == 1){
                String potion1 = mobEffectInstances.get(0).getDescriptionId().substring(17);
                int length = potion1.length();
                int c1 = 0;
                int c2 = 0;
                int c3 = 0;
                int total = 0;
                for (int i = 0; i < length; i++){
                    c1 = potion1.charAt(i) / 3;
                    total = c1 + c2 + c3;
                    potionID.append((char) total);
                }
            }else if (mobEffectInstances.size() == 2){
                String potion1 = mobEffectInstances.get(0).getDescriptionId().substring(17);
                String potion2 = mobEffectInstances.get(1).getDescriptionId().substring(17);
                int length = Math.min(potion1.length(), potion2.length());
                int c1 = 0;
                int c2 = 0;
                int c3 = 0;
                int total = 0;
                for (int i = 0; i < length; i++){
                    c1 = potion1.charAt(i) / 3;
                    c2 = potion2.charAt(i) / 3;
                    total = c1 + c2 + c3;
                    potionID.append((char) total);
                }
            }else if (mobEffectInstances.size() >= 3){
                String potion1 = mobEffectInstances.get(0).getDescriptionId().substring(17);
                String potion2 = mobEffectInstances.get(1).getDescriptionId().substring(17);
                String potion3 = mobEffectInstances.get(2).getDescriptionId().substring(17);
                int length = Math.min(potion1.length(), Math.min(potion2.length(), potion3.length()));
                int c1 = 0;
                int c2 = 0;
                int c3 = 0;
                int total = 0;
                for (int i = 0; i < length; i++){
                    c1 = potion1.charAt(i) / 3;
                    c2 = potion2.charAt(i) / 3;
                    c3 = potion3.charAt(i) / 3;
                    total = c1 + c2 + c3;
                    potionID.append((char) total);
                }
            }
            return Component.translatable(this.getDescriptionId())
                    .append(Component.translatable("§k" + potionID.toString()).append(Component.translatable("§r Potion")));
        }else if (PotionUtils.getPotion(itemStack) == Potions.EMPTY){
            potionID = new StringBuilder("Uncraftable");
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID.toString())).append(Component.translatable(" Potion"));
            //return Component.translatable(potionID).append(Component.translatable(this.getDescriptionId()));
        }else if (PotionUtils.getPotion(itemStack) == Potions.WATER){
            potionID = new StringBuilder("Water");
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID.toString()));
        }else if (PotionUtils.getPotion(itemStack) == Potions.AWKWARD){
            potionID = new StringBuilder("Awkward");
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID.toString())).append(Component.translatable( " Potion"));
        }else if (PotionUtils.getPotion(itemStack) == Potions.THICK){
            potionID = new StringBuilder("Thick");
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID.toString())).append(Component.translatable(" Potion"));
        }else if (PotionUtils.getPotion(itemStack) == Potions.MUNDANE){
            potionID = new StringBuilder("Mundane");
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID.toString())).append(Component.translatable(" Potion"));
        }else{
            potionID = new StringBuilder(Component.translatable(PotionUtils.getPotion(itemStack).getName("item.minecraft.potion.effect.")).getString());
            String capPotionName = Component.translatable(potionID.substring(10)).getString();
            capPotionName = capPotionName.substring(0, 1).toUpperCase() + capPotionName.substring(1);
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(capPotionName)).append(Component.translatable(" Potion"));
        }
    }
}
