package io.github.defnot001.mixin.client;

import io.github.defnot001.defmod.Defmod;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelBakery.class)
public abstract class ModelBakeryMixin {
    @Shadow protected abstract void loadTopLevel(ModelResourceLocation location);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model" +
        "/ModelBakery;loadTopLevel(Lnet/minecraft/client/resources/model/ModelResourceLocation;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addRubyStaff(BlockColors blockColors,
                             ProfilerFiller profilerFiller,
                             Map<ResourceLocation, BlockModel> modelResources,
                             Map<ResourceLocation, List<ModelBakery.LoadedJson>> blockStateResources,
                             CallbackInfo ci) {
        this.loadTopLevel(new ModelResourceLocation(Defmod.MOD_ID, "ruby_staff_3d", "inventory"));
    }
}