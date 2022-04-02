package me.kekschen.redworldspawn.utils;

import me.kekschen.redworldspawn.RedWorldSpawn;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class ConfigMessages {
	public static String PREFIX = "&7[&cRedWorldSpawn&7] &r";

	public static void readPrefix(Plugin plugin) {
		String prefix = plugin.getConfig().getString("prefix");
		if(prefix == null) return;
		PREFIX = ChatColor.translateAlternateColorCodes('&', prefix);
	}

	public static String getMessage(Plugin plugin, String key) {
		String text = plugin.getConfig().getString("messages." + key);
		if(text == null) return "";
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}
