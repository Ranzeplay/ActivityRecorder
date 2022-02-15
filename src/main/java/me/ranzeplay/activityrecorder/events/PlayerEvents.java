package me.ranzeplay.activityrecorder.events;

import me.ranzeplay.activityrecorder.ActivityRecorder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerEvents {
	private static final Timer timer = new Timer();

	public static void PlayerJoinEvent(ServerPlayerEntity player, MinecraftServer server) {
		var task = new TimerTask() {
			@Override
			public void run() {
				player.sendMessage(Text.of("Welcome to my server"), true);
			}
		};

		timer.schedule(task, 2000);
	}

	public static void PlayerLeaveEvent(ServerPlayerEntity player, MinecraftServer server) {
		ActivityRecorder.LOGGER.info("Recorded %s left server".formatted(player.getEntityName()));
	}
}
