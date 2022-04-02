package me.kekschen.redworldspawn;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.kekschen.redworldspawn.commands.WSpawnCommand;
import me.kekschen.redworldspawn.utils.ConfigMessages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RedWorldSpawn extends JavaPlugin {

	@Override
	public void onLoad() {
		saveDefaultConfig();
	}

	@Override
	public void onEnable() {
		MultiverseCore mv = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

		ConfigMessages.readPrefix(this);

		Bukkit.getPluginCommand("wspawn").setExecutor(new WSpawnCommand(this, mv));
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

}
