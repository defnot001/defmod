package io.github.defnot001.defmod.datagen;

import io.github.defnot001.defmod.Defmod;
import io.github.defnot001.defmod.block.ModBlocks;
import io.github.defnot001.defmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;

import static io.github.defnot001.defmod.datagen.recipes.ModRecipeUtils.*;

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
        modNineBlockStorageRecipesDefaultCategories(exporter, ModItems.RAW_RUBY, ModBlocks.RAW_RUBY_BLOCK);

        modStairs(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_STAIRS);
        modSlab(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_SLAB);
        modButton(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_BUTTON);
        modPressurePlate(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_PRESSURE_PLATE);
        modFence(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_FENCE);
        modFenceGate(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_FENCE_GATE);
        modWall(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_WALL);
        modDoor(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_DOOR);
        modTrapdoor(exporter, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_TRAPDOOR);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
            .pattern("###")
            .pattern("#C#")
            .pattern("###")
            .define('#', Items.STONE)
            .define('C', ModItems.RUBY)
            .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
            .unlockedBy(getHasName(ModItems.RAW_RUBY), has(ModItems.RAW_RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, "raw_ruby_from_ruby"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_STAFF, 1)
            .pattern(" R ")
            .pattern(" # ")
            .pattern(" # ")
            .define('#', Items.IRON_INGOT)
            .define('R', ModItems.RUBY)
            .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_STAFF)));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE)
            .define('#', Items.STICK)
            .define('X', ModItems.RUBY)
            .pattern("XXX")
            .pattern(" # ")
            .pattern(" # ")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_PICKAXE)));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL)
            .define('#', Items.STICK)
            .define('X', ModItems.RUBY)
            .pattern("X")
            .pattern("#")
            .pattern("#")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_SHOVEL)));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD)
            .define('#', Items.STICK)
            .define('X', ModItems.RUBY)
            .pattern("X")
            .pattern("X")
            .pattern("#")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_SWORD)));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HOE)
            .define('#', Items.STICK)
            .define('X', ModItems.RUBY)
            .pattern("XX")
            .pattern(" #")
            .pattern(" #")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_HOE)));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_AXE)
            .define('#', Items.STICK)
            .define('X', ModItems.RUBY)
            .pattern("XX")
            .pattern("X#")
            .pattern(" #")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_AXE)));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_HELMET)
            .define('X', ModItems.RUBY)
            .pattern("XXX")
            .pattern("X X")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_HELMET)));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE)
            .define('X', ModItems.RUBY)
            .pattern("X X")
            .pattern("XXX")
            .pattern("XXX")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_CHESTPLATE)));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS)
            .define('X', ModItems.RUBY)
            .pattern("XXX")
            .pattern("X X")
            .pattern("X X")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_LEGGINGS)));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS)
            .define('X', ModItems.RUBY)
            .pattern("X X")
            .pattern("X X")
            .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
            .save(exporter, new ResourceLocation(Defmod.MOD_ID, getSimpleRecipeName(ModItems.RUBY_BOOTS)));
    }
}
