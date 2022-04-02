package me.kekschen.redworldspawn;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.kekschen.redworldspawn.commands.WSpawnCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RedWorldSpawn extends JavaPlugin {
	public static String PREFIX = "§7[§4Red§rWorldSpawn§7]: §r";

	@Override
	public void onLoad() {
		saveDefaultConfig();
		PREFIX = getConfig().getString("prefix");
	}

	@Override
	public void onEnable() {
		MultiverseCore mv = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

		Bukkit.getPluginCommand("wspawn").setExecutor(new WSpawnCommand(this, mv));
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
