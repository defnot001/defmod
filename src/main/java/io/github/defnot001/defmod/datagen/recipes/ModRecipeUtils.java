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

    public static void modStairs(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike stairs) {
        stairBuilder(stairs, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(stairs)));
    }

    public static void modSlab(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike slab) {
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(slab)));
    }

    public static void modButton(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike button) {
        buttonBuilder(button, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(button)));
    }

    public static void modPressurePlate(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike pressurePlate) {
        pressurePlateBuilder(RecipeCategory.REDSTONE, pressurePlate, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(pressurePlate)));
    }

    public static void modFence(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike fence) {
        fenceBuilder(fence, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(fence)));
    }

    public static void modFenceGate(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike fenceGate) {
        fenceGateBuilder(fenceGate, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(fenceGate)));
    }

    public static void modWall(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike wall) {
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(wall)));
    }

    public static void modDoor(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike door) {
        doorBuilder(door, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(door)));
    }

    public static void modTrapdoor(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike trapdoor) {
        trapdoorBuilder(trapdoor, Ingredient.of(ingredient))
            .unlockedBy(getHasName(ingredient), has(ingredient))
            .save(recipeOutput, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(trapdoor)));
    }
}
