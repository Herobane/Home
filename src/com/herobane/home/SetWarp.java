package com.herobane.home;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarp implements CommandExecutor {

	public Main plugin;
	
	public SetWarp(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = (Player) sender;
		Location location = player.getLocation();
		World world = player.getWorld();
		
		if(command.getName().equalsIgnoreCase("setwarp")) {
			if(args.length == 1) {
				if(player.isOp()) {
					plugin.getConfig().createSection("Warp." + world + "." + args[0]);
					plugin.getConfig().createSection("Warp." + world + "." + args[0] + ".x");
					plugin.getConfig().createSection("Warp." + world + "." + args[0] + ".y");
					plugin.getConfig().createSection("Warp." + world + "." + args[0] + ".z");
					plugin.saveConfig();
					
					double x = location.getX();
					double y = location.getY();
					double z = location.getZ();
					
					plugin.getConfig().set("Warp." + world + "." + args[0] + ".x", x);
					plugin.getConfig().set("Warp." + world + "." + args[0] + ".y", y);
					plugin.getConfig().set("Warp." + world + "." + args[0] + ".z", z);
					plugin.saveConfig();
					
					player.sendMessage(ChatColor.GREEN + "Le Warp " + args[0] + " à été crée");
				} else {
					player.sendMessage(ChatColor.DARK_RED + "Seul les administrateurs sont autorisés à créer des Warps");
				}
			} else {
				player.sendMessage(ChatColor.DARK_RED + "La command \"setwarp\" requiert un argument");
			}
		}
		
		return false;
	}

}
