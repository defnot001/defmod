package io.github.defnot001.defmod.item;

import io.github.defnot001.defmod.Defmod;
import io.github.defnot001.defmod.item.custom.MetalDetectorItem;
import io.github.defnot001.defmod.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
        new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item TOMATO = registerItem("tomato",
        new Item(new FabricItemSettings().food(ModFoodProperties.TOMATO)));
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette",
        new Item(new FabricItemSettings()));
    public static final Item RUBY_STAFF = registerItem("ruby_staff",
        new Item(new FabricItemSettings().maxCount(1)));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
        new PickaxeItem(ModToolMaterial.RUBY, 2, 2f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
        new AxeItem(ModToolMaterial.RUBY, 3, 1f, new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
        new ShovelItem(ModToolMaterial.RUBY, 0, 0f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
        new SwordItem(ModToolMaterial.RUBY, 5, 3f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
        new HoeItem(ModToolMaterial.RUBY, 0, 0f, new FabricItemSettings()));
    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
        new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
        new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
        new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
        new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    /**
     * Adds items to the vanilla Ingredient Creative Mod Tab
     */
    private static void addItemsToIngredientTab(FabricItemGroupEntries entries) {
        entries.accept(RUBY);
        entries.accept(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Defmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Defmod.LOGGER.info("Registering Mod Items for " + Defmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(ModItems::addItemsToIngredientTab);
    }
}
