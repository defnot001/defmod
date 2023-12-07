package io.github.defnot001.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.defnot001.defmod.Defmod;
import io.github.defnot001.defmod.item.ModItems;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "render", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRubyStaffModel(BakedModel bakedModel, ItemStack itemStack, ItemDisplayContext itemDisplayContext, boolean leftHanded, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        if (itemStack.is(ModItems.RUBY_STAFF) && itemDisplayContext != ItemDisplayContext.GUI) {
            return ((ItemRendererAccessor) this).defmod$getItemModelShaper().getModelManager().getModel(new ModelResourceLocation(Defmod.MOD_ID, "ruby_staff_3d", "inventory"));
        }
        return bakedModel;
    }
}
