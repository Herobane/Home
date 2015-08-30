package com.herobane.home;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {

	public Main plugin;
	
	public Home(Main main) {
		this.plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
		if(command.getName().equalsIgnoreCase("home")) {
			double x = plugin.getConfig().getDouble("Home." + player.getName() + ".x");
			double y = plugin.getConfig().getDouble("Home." + player.getName() + ".y");
			double z = plugin.getConfig().getDouble("Home." + player.getName() + ".z");
			
			if(x != 0.0 && y != 0.0 && z != 0.0) {
				World world = player.getWorld();
				
				Location location = new Location(world, x, y, z);
				
				player.teleport(location);
				
				player.sendMessage(ChatColor.GREEN + "Vous avez été téléporté à votre home");
			} else {
				player.sendMessage(ChatColor.DARK_RED + "Vous ne possédez pas de home. Définissez-en un en faisant /sethome");
			}
		}
		
		return false;
	}

}
