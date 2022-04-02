package me.kekschen.redworldspawn.commands;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.kekschen.redworldspawn.RedWorldSpawn;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WSpawnCommand implements CommandExecutor {
	private final RedWorldSpawn plugin;
	private final MultiverseCore multiverseCore;

	public WSpawnCommand(RedWorldSpawn plugin, MultiverseCore multiverseCore) {
		this.plugin = plugin;
		this.multiverseCore = multiverseCore;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage(RedWorldSpawn.PREFIX + plugin.getConfig().getString("messages.onlyPlayer"));
			return true;
		}
		if(!sender.hasPermission("rwm.redworldspawn.use")) {
			sender.sendMessage(RedWorldSpawn.PREFIX + plugin.getConfig().getString("messages.noPermission"));
			return true;
		}

		Player player = (Player) sender;
		Location spawn = multiverseCore.getMVWorldManager().getMVWorld(player.getWorld()).getSpawnLocation();
		player.teleport(spawn);

		sender.sendMessage(RedWorldSpawn.PREFIX + plugin.getConfig().getString("messages.teleported"));

		return true;
	}
}
