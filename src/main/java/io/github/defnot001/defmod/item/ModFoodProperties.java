package io.github.defnot001.defmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TOMATO = new FoodProperties.Builder()
        .nutrition(3)
        .saturationMod(0.25f)
        .effect(new MobEffectInstance(MobEffects.LUCK, 200), 0.25f)
        .build();
}
