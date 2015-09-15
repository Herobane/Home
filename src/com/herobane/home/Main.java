package com.herobane.home;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		Event event = new Event();
		
		getConfig().options().copyDefaults(false);
		this.saveConfig();
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(event, this);
		
		getCommand("sethome").setExecutor(new SetHome(this));
		getCommand("home").setExecutor(new Home(this));
		getCommand("setwarp").setExecutor(new SetWarp(this));
		getCommand("warp").setExecutor(new Warp(this));
	}
	
	public void onDisable() {
		
	}
	
}
