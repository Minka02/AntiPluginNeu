package com.plugin.load;

import org.bukkit.ChatColor;

import com.coder.client.main.PluginRegistry;
import com.coder.client.main.YmlFile;
import com.plugin.Handler.BlockHandler;
import com.plugin.Handler.CraftingHandler;
import com.plugin.Handler.DamageHandler;
import com.plugin.Handler.InteractHandler;
import com.plugin.Handler.ItemHandler;
import com.plugin.Handler.JoinHandler;
import com.plugin.commands.Info_ingame;
import com.plugin.commands.OK;

public class PluginLoader {
	public void loadPlugin() {
		new Config().cfgGen();
		
			// Registry Listener
		PluginRegistry.registerListener(new JoinHandler());
		PluginRegistry.registerListener(new BlockHandler());
		PluginRegistry.registerListener(new CraftingHandler());
		PluginRegistry.registerListener(new DamageHandler());
		PluginRegistry.registerListener(new InteractHandler());
		PluginRegistry.registerListener(new ItemHandler());
		//PluginRegistry.registerListener(new ChatHandler());
		
		//PluginRegistry.registerListener(listener);
		
		if(YmlFile.loadConfig("config.yml").getBoolean("Prefix")) {
			// mit ap
			PluginRegistry.registerCommand("ok", new OK ("ok"));
			
		}else {
			// ohne ap 
			PluginRegistry.registerCommand("ok", new OK ("ok"));
			
		}
		
		
		// unabhängig von der config und von "Prefix" System
		PluginRegistry.registerCommand("info", new Info_ingame("info"));
		
	}
	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

}