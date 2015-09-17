package com.herobane.home;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warp implements CommandExecutor {

	public Main plugin;
	
	public Warp(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = (Player) sender;
		World world = player.getWorld();
		
		if(command.getName().equalsIgnoreCase("warp")) {
			
			if(args.length == 1) {
				double x = plugin.getConfig().getDouble("Warp." + world + "." + args[0] + ".x");
				double y = plugin.getConfig().getDouble("Warp." + world + "." + args[0] + ".y");
				double z = plugin.getConfig().getDouble("Warp." + world + "." + args[0] + ".z");
				
				if(x != 0.0 && y != 0.0 && z != 0.0) {
					
					Location location = new Location(world, x, y, z);
					
					player.teleport(location);
					
					player.sendMessage(ChatColor.GREEN + "Vous avez été téléporté au warp " + args[0]);
				} else {
					player.sendMessage(ChatColor.DARK_RED + "Le warp " + args[0] + " n'existe pas encore. Définissez le en entrant : \"/setwarp " + args[0] + "\"");
				}
				
			} else {
				player.sendMessage(ChatColor.DARK_RED + "La command \"warp\" requiert un argument");
			}
		}
		
		return false;
	}

}
