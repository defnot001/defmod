package io.github.defnot001.defmod.datagen;

import io.github.defnot001.defmod.block.ModBlocks;
import io.github.defnot001.defmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
            .add(ModBlocks.RUBY_ORE)
            .forceAddTag(BlockTags.GOLD_ORES)
            .forceAddTag(BlockTags.IRON_ORES)
            .forceAddTag(BlockTags.COPPER_ORES);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.RAW_RUBY_BLOCK)
            .add(ModBlocks.RUBY_BLOCK)
            .add(ModBlocks.RUBY_ORE)
            .add(ModBlocks.DEEPSLATE_RUBY_ORE)
            .add(ModBlocks.NETHER_RUBY_ORE)
            .add(ModBlocks.END_STONE_RUBY_ORE)
            .add(ModBlocks.SOUND_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.RAW_RUBY_BLOCK)
            .add(ModBlocks.RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("fabric", "needs_tool_level_4")))
            .add(ModBlocks.END_STONE_RUBY_ORE);

        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("fabric", "needs_tool_level_5")))
            .add(ModBlocks.SOUND_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES)
            .add(ModBlocks.RUBY_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
            .add(ModBlocks.RUBY_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
            .add(ModBlocks.RUBY_WALL);
    }
}
