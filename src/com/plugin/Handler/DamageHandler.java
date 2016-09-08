package com.plugin.Handler;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class DamageHandler implements Listener {
	
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Entity en = e.getEntity();
		if(en instanceof Player) {
			Player p = (Player)en;
			if(!p.isOp()) {
			    YmlFile.setAllPath("ehd/Anti/Player");
			    YamlConfiguration c = YmlFile.loadConfig(p.getUniqueId() + " .yml");
				if(c.getString("ok").equalsIgnoreCase("f")&& YmlFile.loadConfig(p.getUniqueId() + " .yml").getString("ok").equalsIgnoreCase("t")) {
					e.setCancelled(true);
					p.setFallDistance(0.0F);
					p.setLastDamage(0.0D);
					p.setHealth(20.0D);
					p.setFoodLevel(20);
					p.setFireTicks(0);
					p.setRemainingAir(10);
				}
			}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		Entity damager = e.getDamager();
		
		//Player Damager
		if(damager instanceof Player) {
			Player p = (Player)damager;
		    YmlFile.setAllPath("ehd/Anti/Player");
		    YamlConfiguration c1 = YmlFile.loadConfig(p.getUniqueId() + " .yml");
			if(!p.isOp()) {
				if(c1.getString("ok").equalsIgnoreCase("f")&& YmlFile.loadConfig(p.getUniqueId() + " .yml").getString("ok").equalsIgnoreCase("t")) {
					e.setCancelled(true);
					p.sendMessage(PluginLoader.color("&4Keine Erlaubnis"));
				}
			}
		}
	}
	
}
