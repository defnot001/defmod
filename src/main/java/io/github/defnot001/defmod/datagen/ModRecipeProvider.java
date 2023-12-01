package io.github.defnot001.defmod.datagen;

import io.github.defnot001.defmod.Defmod;
import io.github.defnot001.defmod.block.ModBlocks;
import io.github.defnot001.defmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE,
        ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE);

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        modOreSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby");
        modOreBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby");

        modNineBlockStorageRecipesDefaultCategories(exporter, ModItems.RUBY, ModBlocks.RUBY_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
            .pattern("###")
            .pattern("#C#")
            .pattern("###")
            .define('#', Items.STONE)
            .define('C', ModItems.RUBY)
            .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
            .unlockedBy(getHasName(ModItems.RAW_RUBY), has(ModItems.RAW_RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, "raw_ruby_from_ruby"));
    }

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

    private static void modNineBlockStorageRecipesDefaultCategories(
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
