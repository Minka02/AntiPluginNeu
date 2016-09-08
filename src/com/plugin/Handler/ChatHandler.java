package com.plugin.Handler;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class ChatHandler implements Listener {

	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
	    YmlFile.setAllPath("ehd/Anti/Player");
	    YamlConfiguration c = YmlFile.loadConfig(p.getUniqueId() + " .yml");
		if(c.getString("mute").equalsIgnoreCase("t")) {
			e.setCancelled(true);
			p.sendMessage(PluginLoader.color("&4Du bist Gemutet"));
		}
	}

}
