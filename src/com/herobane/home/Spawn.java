package com.herobane.home;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
	
	public Main plugin;

	public Spawn(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = (Player) sender;
		World world = player.getWorld();
		
		if(command.getName().equalsIgnoreCase("spawn")) {
			
			double x = plugin.getConfig().getDouble("Spawn." + world + ".x");
			double y = plugin.getConfig().getDouble("Spawn." + world + ".y");
			double z = plugin.getConfig().getDouble("Spawn." + world + ".z");
			
			if(x != 0.0 && y != 0.0 && z != 0.0) {
				
				Location location = new Location(world, x, y, z);
				
				player.teleport(location);
				player.sendMessage(ChatColor.GREEN + "Vous avez été téléporté au spawn");
				
			} else {
				player.sendMessage(ChatColor.DARK_RED + "Aucun spawn n'as été défini. Défnissez en un en entrant /setspawn");
			}
			
		}
		
		return false;
	}

}
