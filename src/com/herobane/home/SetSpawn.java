package com.herobane.home;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
	
	public Main plugin;

	public SetSpawn(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = (Player) sender;
		World world = player.getWorld();
		Location location = player.getLocation();
		
		if(command.getName().equalsIgnoreCase("setspawn")) {
			
			if(player.isOp()) {
				
				plugin.getConfig().createSection("Spawn." + world);
				plugin.getConfig().createSection("Spawn." + world + ".x");
				plugin.getConfig().createSection("Spawn." + world + ".y");
				plugin.getConfig().createSection("Spawn." + world + ".z");
				plugin.saveConfig();
				
				double x = location.getX();
				double y = location.getY();
				double z = location.getZ();
				
				plugin.getConfig().set("Spawn." + world + ".x", x);
				plugin.getConfig().set("Spawn." + world + ".y", y);
				plugin.getConfig().set("Spawn." + world + ".z", z);
				plugin.saveConfig();
				
				player.sendMessage("Le spawn à été défini");
			} else {
				player.sendMessage(ChatColor.DARK_RED + "Seul les administrateurs sont autorisés à définir le spawn");
			}
			
		}
		
		return false;
	}

}
