package io.github.defnot001.defmod.datagen.recipes;

import io.github.defnot001.defmod.Defmod;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;

import static net.minecraft.data.recipes.RecipeProvider.*;


public class ModRecipeUtils {
    private static void modNineBlockStorageRecipes(
        RecipeOutput recipeOutput,
        RecipeCategory unpackedCategory,
        ItemLike unpacked,
        RecipeCategory packedCategory,
        ItemLike packed
    ) {
        nineBlockStorageRecipes(
            recipeOutput,
            unpackedCategory, unpacked,
            packedCategory, packed,
            Defmod.MOD_ID + ":" + getSimpleRecipeName(packed), null,
            Defmod.MOD_ID + ":" + getSimpleRecipeName(unpacked), null
        );
    }

    public static void modNineBlockStorageRecipesDefaultCategories(
        RecipeOutput recipeOutput,
        ItemLike unpacked,
        ItemLike packed
    ) {
        modNineBlockStorageRecipes(
            recipeOutput,
            RecipeCategory.DECORATIONS, unpacked,
            RecipeCategory.BUILDING_BLOCKS, packed
        );
    }

    public static void modOreCooking(
        RecipeOutput recipeOutput,
        RecipeSerializer<? extends AbstractCookingRecipe> serializer,
        List<ItemLike> ingredients,
        RecipeCategory category,
        ItemLike result,
        float experience,
        int cookingTime,
        String group,
        String suffix
    ) {
        for(ItemLike itemLike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), category, result, experience, cookingTime, serializer)
                .group(group)
                .unlockedBy(getHasName(itemLike), has(itemLike))
                .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getItemName(result) + suffix + "_" + getItemName(itemLike)));
        }
    }

    public static void modOreBlasting(
        RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        modOreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, ingredients, category, result, experience,
            cookingTime, group, "_from_blasting");
    }

    public static void modOreSmelting(
        RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        modOreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, ingredients, category, result, experience,
            cookingTime, group, "_from_smelting");
    }
}
