package net.creep3rcrafter.jarred;

import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Stream;

public class PotionMixRecipe extends CustomRecipe {
    private final String group;
    public final ItemStack result;
    private final NonNullList<Ingredient> ingredients;

    public PotionMixRecipe(ResourceLocation resourceLocation, String group, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(resourceLocation);
        this.group = group;
        this.result = result;
        this.ingredients = ingredients;
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        return (container.getItem(0).getItem() instanceof PotionItem);
    }

    @Override
    public ItemStack assemble(CraftingContainer container) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth * pHeight >= this.ingredients.size();
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
        return super.getRemainingItems(container);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getToastSymbol() {
        ItemStack potionItem = new ItemStack(() -> new PotionItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
        List<MobEffectInstance> effects = new ArrayList<>();
        effects.add(new MobEffectInstance(MobEffects.HEAL, 1, 2));
        PotionUtils.setCustomEffects(potionItem, effects);
        return potionItem;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }
}
