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
        blockStateGen.createTrivialCube(ModBlocks.RAW_RUBY_BLOCK);
        blockStateGen.createTrivialCube(ModBlocks.RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.NETHER_RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.END_STONE_RUBY_ORE);
        blockStateGen.createTrivialCube(ModBlocks.SOUND_BLOCK);

        blockStateGen.createDoor(ModBlocks.RUBY_DOOR);
        blockStateGen.createTrapdoor(ModBlocks.RUBY_TRAPDOOR);

        var rubyFamily = blockStateGen.family(ModBlocks.RUBY_BLOCK);

        rubyFamily.stairs(ModBlocks.RUBY_STAIRS);
        rubyFamily.slab(ModBlocks.RUBY_SLAB);
        rubyFamily.button(ModBlocks.RUBY_BUTTON);
        rubyFamily.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyFamily.fence(ModBlocks.RUBY_FENCE);
        rubyFamily.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyFamily.wall(ModBlocks.RUBY_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemGen) {
        itemGen.generateFlatItem(ModItems.RUBY, ModelTemplates.FLAT_ITEM);
        itemGen.generateFlatItem(ModItems.RAW_RUBY, ModelTemplates.FLAT_ITEM);

        itemGen.generateFlatItem(ModItems.COAL_BRIQUETTE, ModelTemplates.FLAT_ITEM);
        itemGen.generateFlatItem(ModItems.TOMATO, ModelTemplates.FLAT_ITEM);

        itemGen.generateFlatItem(ModItems.METAL_DETECTOR, ModelTemplates.FLAT_ITEM);

        itemGen.generateFlatItem(ModItems.RUBY_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemGen.generateFlatItem(ModItems.RUBY_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemGen.generateFlatItem(ModItems.RUBY_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemGen.generateFlatItem(ModItems.RUBY_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemGen.generateFlatItem(ModItems.RUBY_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);

    }
}