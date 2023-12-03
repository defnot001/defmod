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
}
