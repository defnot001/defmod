package io.github.defnot001.defmod.block;

import io.github.defnot001.defmod.Defmod;
import io.github.defnot001.defmod.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(SoundType.AMETHYST)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(SoundType.AMETHYST)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
        new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformInt.of(2, 5)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
        new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformInt.of(2, 5)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
        new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformInt.of(2, 5)));
    public static final Block END_STONE_RUBY_ORE = registerBlock("end_stone_ruby_ore",
        new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f), UniformInt.of(4, 7)));
    public static final Block SOUND_BLOCK = registerBlock("sound_block",
        new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Defmod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
            BuiltInRegistries.ITEM,
            new ResourceLocation(Defmod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings())
        );
    }

    public static void registerModBlocks() {
        Defmod.LOGGER.info("Registering ModBlocks for " + Defmod.MOD_ID);
    }
}
