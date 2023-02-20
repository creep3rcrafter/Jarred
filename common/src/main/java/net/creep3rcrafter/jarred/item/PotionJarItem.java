package net.creep3rcrafter.jarred.item;

import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.creep3rcrafter.jarred.register.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
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

import java.util.Iterator;
import java.util.List;

public class PotionJarItem extends PotionItem {
    public PotionJarItem(Item.Properties properties) {
        super(properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        if (!level.isClientSide) {
            List<MobEffectInstance> list = PotionUtils.getMobEffects(itemStack);
            Iterator var6 = list.iterator();

            while(var6.hasNext()) {
                MobEffectInstance mobEffectInstance = (MobEffectInstance)var6.next();
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
    public void fillItemCategory(CreativeModeTab creativeModeTab, NonNullList<ItemStack> nonNullList) {
        if (this.allowedIn(creativeModeTab)) {
            Iterator var3 = Registry.POTION.iterator();
            while(var3.hasNext()) {
                Potion potion = (Potion)var3.next();
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
    public Component getName(ItemStack itemStack) {
        String potionID;
        if (PotionUtils.getPotion(itemStack) == Potions.EMPTY){
            potionID = "Uncraftable";
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID)).append(Component.translatable(" Potion"));
            //return Component.translatable(potionID).append(Component.translatable(this.getDescriptionId()));
        }else if (PotionUtils.getPotion(itemStack) == Potions.WATER){
            potionID = "Water";
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID));
        }else if (PotionUtils.getPotion(itemStack) == Potions.AWKWARD){
            potionID = "Awkward";
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID)).append(Component.translatable( " Potion"));
        }else if (PotionUtils.getPotion(itemStack) == Potions.THICK){
            potionID = "Thick";
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID)).append(Component.translatable(" Potion"));
        }else if (PotionUtils.getPotion(itemStack) == Potions.MUNDANE){
            potionID = "Mundane";
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(potionID)).append(Component.translatable(" Potion"));
        }else{
            potionID = Component.translatable(PotionUtils.getPotion(itemStack).getName("item.minecraft.potion.effect.")).getString();
            String capPotionName = Component.translatable(potionID.substring(10)).getString();
            capPotionName = capPotionName.substring(0, 1).toUpperCase() + capPotionName.substring(1);
            return Component.translatable(this.getDescriptionId()).append(Component.translatable(capPotionName)).append(Component.translatable(" Potion"));
        }
    }
}
