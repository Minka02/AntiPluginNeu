package com.plugin.load;

import org.bukkit.ChatColor;

import com.coder.client.main.PluginRegistry;
import com.coder.client.main.YmlFile;
import com.plugin.commands.Info_ingame;

public class PluginLoader {
	public void loadPlugin() {
		
			// Registry Listener
		
		//PluginRegistry.registerListener(listener);
		
		if(YmlFile.loadConfig("config.yml").getBoolean("Prefix")) {
			// mit ap
			
			
		}else {
			// ohne ap 
			
			
		}
		
		
		// unabhängig von der config und von "Prefix" System
		PluginRegistry.registerCommand("info", new Info_ingame("info"));
		
	}
	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

}