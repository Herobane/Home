package com.herobane.home;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor {
	
	public Main plugin;
	
	public SetHome(Main main) {
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = (Player) sender;
		Location location = player.getLocation();
		World world = player.getWorld();
		
		if(command.getName().equalsIgnoreCase("sethome")) {
			plugin.getConfig().createSection("Home." + world + "." + player.getName());
			plugin.getConfig().createSection("Home." + world + "." + player.getName() + ".x");
			plugin.getConfig().createSection("Home." + world + "." + player.getName() + ".y");
			plugin.getConfig().createSection("Home." + world + "." + player.getName() + ".y");
			plugin.saveConfig();
			
			double x = location.getBlockX();
			double y = location.getBlockY();
			double z = location.getBlockZ();
			
			plugin.getConfig().set("Home." + world + "." + player.getName() + ".x", x);
			plugin.getConfig().set("Home." + world + "." + player.getName() + ".y", y);
			plugin.getConfig().set("Home." + world + "." + player.getName() + ".z", z);
			plugin.saveConfig();
			
			player.sendMessage(ChatColor.GREEN + "Votre Home a été défini");
		}
		
		return false;
	}

}
