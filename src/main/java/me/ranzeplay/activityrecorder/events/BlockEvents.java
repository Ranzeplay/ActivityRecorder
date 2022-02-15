package me.ranzeplay.activityrecorder.events;

import me.ranzeplay.activityrecorder.ActivityRecorder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEvents {

	public static void BreakBlock(World world, PlayerEntity player, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity) {
		ActivityRecorder.LOGGER.info("Detected block destroyed in world %s at location %s %s %s by %s".formatted(world.asString(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), player.getEntityName()));
	}

	public static ActionResult UseBlock(PlayerEntity player, World world, Hand hand, BlockHitResult blockHitResult) {
		var block = world.getBlockEntity(blockHitResult.getBlockPos());
		ActivityRecorder.LOGGER.info("You used a block");

		return ActionResult.PASS;
	}
}
