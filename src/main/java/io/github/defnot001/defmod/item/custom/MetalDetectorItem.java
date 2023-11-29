package io.github.defnot001.defmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();

        if (player == null) {
            return InteractionResult.FAIL;
        }

        if (!context.getLevel().isClientSide()) {
            BlockPos positionClicked = context.getClickedPos();
            boolean foundBlock = false;

            for (int i = 0; i < positionClicked.getY() + 64; i++) {
                BlockState state = context.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if (!foundBlock) {
                player.displayClientMessage(Component.literal("No Valuables found!"), false);
            }

        }

        context.getItemInHand().hurtAndBreak(1, player,
            p -> p.broadcastBreakEvent(player.getUsedItemHand()));


        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.displayClientMessage(Component.literal(String.format("Found %s at (%s, %s, %s)",
            block.getName().getString(), blockPos.getX(), blockPos.getY(), blockPos.getZ())), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.RAW_IRON_BLOCK);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        tooltipComponents.add(Component.translatable("tooltip.defmod.metal_detector.tooltip"));
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}
