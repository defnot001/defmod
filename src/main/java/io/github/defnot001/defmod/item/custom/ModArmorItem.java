package io.github.defnot001.defmod.item.custom;

import com.google.common.collect.ImmutableMap;
import io.github.defnot001.defmod.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_MOB_EFFECT_INSTANCE_MAP =
        (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
            .put(
                ModArmorMaterials.RUBY,
                new MobEffectInstance(MobEffects.DIG_SPEED, 400, 1, false, false, true)
            )
            .build();
    public ModArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide()) {
            if(entity instanceof Player player && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !(helmet.isEmpty() || chestplate.isEmpty() || leggings.isEmpty() || boots.isEmpty());
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_MOB_EFFECT_INSTANCE_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapMobEffectInstance = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectFromMaterial(player, mapArmorMaterial, mapMobEffectInstance);
            }
        }
    }

    private void addStatusEffectFromMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffectInstance mapMobEffectInstance) {
        boolean hasPlayerEffect = player.hasEffect(mapMobEffectInstance.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapMobEffectInstance));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && chestplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
