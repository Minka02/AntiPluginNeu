package com.plugin.Handler;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.coder.client.main.YmlFile;

public class JoinHandler implements Listener {


	@EventHandler 
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
	    YmlFile.setAllPath("ehd/Anti/Player");
	    YamlConfiguration c = YmlFile.loadConfig(p.getUniqueId() + " .yml");
	    if (!YmlFile.configExists(p.getUniqueId() + " .yml")) {
	      YmlFile.generateConfig(p.getUniqueId() + " .yml");
			c.set("MC-name", p.getName());
			c.set("Anti", 0);
			c.set("Ok", "f");
			c.set("ok_banned", false);
			c.set("mute", "f");
			c.set("Adress", p.getAddress().toString());
	      YmlFile.save();
	    }

	}

}
