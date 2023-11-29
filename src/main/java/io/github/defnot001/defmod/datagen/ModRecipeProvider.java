package io.github.defnot001.defmod.datagen;

import io.github.defnot001.defmod.block.ModBlocks;
import io.github.defnot001.defmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
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
        oreSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby");
        oreBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby");

        nineBlockStorageRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
            ModBlocks.RUBY_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS,
            ModBlocks.RAW_RUBY_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
            .pattern("###")
            .pattern("#C#")
            .pattern("###")
            .define('#', Items.STONE)
            .define('C', ModItems.RUBY)
            .unlockedBy("has_stone", has(Items.STONE))
            .unlockedBy("has_ruby", has(ModItems.RAW_RUBY))
            .save(exporter, "raw_ruby_from_ruby");
    }
}
