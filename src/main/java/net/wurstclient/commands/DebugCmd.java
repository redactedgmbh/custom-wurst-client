package net.wurstclient.commands;

import net.wurstclient.WurstClient;
import net.wurstclient.command.Command;
import net.wurstclient.util.ChatUtils;

public class DebugCmd extends Command
{
	public DebugCmd()
	{
		super("debug", "Shows debug information.");
	}
	
	@Override
	public void call(String[] args)
	{
		String playerName = WurstClient.MC.getSession().getUsername();
		String gameMode =
			WurstClient.MC.interactionManager.getCurrentGameMode().getName();
		int playerPosX = (int)WurstClient.MC.player.getX();
		int fps = WurstClient.MC.getCurrentFps();
		int playerPosY = (int)WurstClient.MC.player.getY();
		int playerPosZ = (int)WurstClient.MC.player.getZ();
		float playerYaw = WurstClient.MC.player.getYaw();
		float playerPitch = WurstClient.MC.player.getPitch();
		float health = WurstClient.MC.player.getHealth();
		
		ChatUtils.message("Debug Information:");
		ChatUtils.message("Player Name: " + playerName);
		ChatUtils.message("Current Health: " + health);
		ChatUtils.message("Current FPS: " + fps);
		ChatUtils.message("Current Gamemode: " + gameMode);
		ChatUtils.message("Position: X=" + playerPosX + ", Y=" + playerPosY
			+ ", Z=" + playerPosZ);
		ChatUtils
			.message("Rotation: Yaw=" + playerYaw + ", Pitch=" + playerPitch);
	}
}
