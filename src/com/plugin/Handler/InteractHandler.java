package com.plugin.Handler;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class InteractHandler implements Listener {
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
	    YmlFile.setAllPath("ehd/Anti/Player");
	    YamlConfiguration c = YmlFile.loadConfig(p.getUniqueId() + " .yml");
		if(!p.isOp()&&!c.getBoolean("ok_banned")) {
			if(c.getString("Ok").equalsIgnoreCase("false")&&YmlFile.loadConfig(p.getUniqueId() + ".yml").getString("Ok").equalsIgnoreCase("t")) {
				e.setCancelled(true);
				p.sendMessage(PluginLoader.color("&4keine Erlaubnis"));
			}
		}
	}
	
}