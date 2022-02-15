package me.ranzeplay.activityrecorder;

import me.bymartrixx.playerevents.api.event.PlayerJoinCallback;
import me.bymartrixx.playerevents.api.event.PlayerLeaveCallback;
import me.ranzeplay.activityrecorder.events.BlockEvents;
import me.ranzeplay.activityrecorder.events.PlayerEvents;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActivityRecorder implements DedicatedServerModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "activity_recorder";

	@Override
	public void onInitializeServer() {
		PlayerJoinCallback.EVENT.register(PlayerEvents::PlayerJoinEvent);
		PlayerLeaveCallback.EVENT.register(PlayerEvents::PlayerLeaveEvent);

		PlayerBlockBreakEvents.AFTER.register(BlockEvents::BreakBlock);
		UseBlockCallback.EVENT.register(BlockEvents::UseBlock);
	}
}
