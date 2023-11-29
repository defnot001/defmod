package io.github.defnot001.defmod.datagen;

import io.github.defnot001.defmod.block.ModBlocks;
import io.github.defnot001.defmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK);
        dropSelf(ModBlocks.RAW_RUBY_BLOCK);
        dropSelf(ModBlocks.SOUND_BLOCK);

        createCustomOreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY, 2, 5);
        createCustomOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY, 3, 6);
        createCustomOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY, 2, 5);
        createCustomOreDrops(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_RUBY, 3, 6);
    }

    private void createCustomOreDrops(Block block, Item itemDrop, float lowerBound, float upperBound) {
        createSilkTouchDispatchTable(
            block,
            this.applyExplosionDecay(
                block,
                LootItem.lootTableItem(itemDrop)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(lowerBound, upperBound)))
                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            )
        );
    }
}
