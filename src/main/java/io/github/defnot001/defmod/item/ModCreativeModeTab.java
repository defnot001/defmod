package io.github.defnot001.defmod.item;

import io.github.defnot001.defmod.Defmod;
import io.github.defnot001.defmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab RUBY_GROUP = Registry.register(
        BuiltInRegistries.CREATIVE_MODE_TAB,
        new ResourceLocation(Defmod.MOD_ID, "items"),
        FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.RUBY))
            .title(Component.translatable("itemGroup.defmod.items"))
            .displayItems((context, entries) -> {
                entries.accept(ModItems.RUBY);
                entries.accept(ModItems.RAW_RUBY);

                entries.accept(ModBlocks.RUBY_BLOCK);
                entries.accept(ModBlocks.RAW_RUBY_BLOCK);

                entries.accept(ModBlocks.RUBY_ORE);
                entries.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
                entries.accept(ModBlocks.NETHER_RUBY_ORE);
                entries.accept(ModBlocks.END_STONE_RUBY_ORE);

                entries.accept(ModBlocks.RUBY_STAIRS);
                entries.accept(ModBlocks.RUBY_SLAB);
                entries.accept(ModBlocks.RUBY_BUTTON);
                entries.accept(ModBlocks.RUBY_PRESSURE_PLATE);
                entries.accept(ModBlocks.RUBY_FENCE);
                entries.accept(ModBlocks.RUBY_FENCE_GATE);
                entries.accept(ModBlocks.RUBY_WALL);
                entries.accept(ModBlocks.RUBY_DOOR);
                entries.accept(ModBlocks.RUBY_TRAPDOOR);

                entries.accept(ModItems.TOMATO);
                entries.accept(ModItems.COAL_BRIQUETTE);
                entries.accept(ModItems.METAL_DETECTOR);
                entries.accept(ModBlocks.SOUND_BLOCK);
            })
            .build()
    );

    public static void registerItemGroups() {
        Defmod.LOGGER.info("Registering Item Groups for " + Defmod.MOD_ID);
    }
}
