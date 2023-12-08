package io.github.defnot001.defmod.util;

import io.github.defnot001.defmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModLootTableModifiers {
    private static final ResourceLocation JUNGLE_TEMPLE_RESOURCE_LOCATION =
        new ResourceLocation("minecraft", "chests/jungle_temple");
    private static final ResourceLocation CREEPER_RESOURCE_LOCATION =
        new ResourceLocation("minecraft", "entities/creeper");
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (JUNGLE_TEMPLE_RESOURCE_LOCATION.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .when(LootItemRandomChanceCondition.randomChance(0.5f))
                    .add(LootItem.lootTableItem(ModItems.METAL_DETECTOR)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));

                tableBuilder.pool(poolBuilder.build());
            }

            if (CREEPER_RESOURCE_LOCATION.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .when(LootItemRandomChanceCondition.randomChance(1.0f))
                    .add(LootItem.lootTableItem((ModItems.COAL_BRIQUETTE))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));

                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}
