package io.github.defnot001.defmod;

import io.github.defnot001.defmod.block.ModBlocks;
import io.github.defnot001.defmod.item.ModCreativeModeTab;
import io.github.defnot001.defmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Defmod implements ModInitializer {
    public static final String MOD_ID = "defmod";
    public static final Logger LOGGER = LoggerFactory.getLogger("defmod");

    @Override
    public void onInitialize() {
        ModCreativeModeTab.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
    }
}