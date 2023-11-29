package io.github.defnot001.defmod.datagen;

import io.github.defnot001.defmod.block.ModBlocks;
import io.github.defnot001.defmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateGen) {
        blockStateGen.createTrivialCube(ModBlocks.RUBY_BLOCK);
        blockStateGen.createTrivialCube(ModBlocks.RAW_RUBY_BLOCK);
        blockStateGen.createTrivialCube(ModBlocks.RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.NETHER_RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.END_STONE_RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.SOUND_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemGen) {
        itemGen.generateFlatItem(ModItems.RUBY, ModelTemplates.FLAT_ITEM);
        itemGen.generateFlatItem(ModItems.RAW_RUBY, ModelTemplates.FLAT_ITEM);
        itemGen.generateFlatItem(ModItems.COAL_BRIQUETTE, ModelTemplates.FLAT_ITEM);
        itemGen.generateFlatItem(ModItems.TOMATO, ModelTemplates.FLAT_ITEM);
        itemGen.generateFlatItem(ModItems.METAL_DETECTOR, ModelTemplates.FLAT_ITEM);
    }
}