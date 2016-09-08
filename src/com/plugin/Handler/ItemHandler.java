package com.plugin.Handler;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class ItemHandler implements Listener {

	@EventHandler
	public void onItemUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		YmlFile.loadConfig("block.yml");
		YamlConfiguration c = YmlFile.loadConfig("block.yml");
		if(!p.isOp()) {

			List<String> items = c.getStringList("items");
			for(String item : items) {
				Material ml = Material.getMaterial(item);
				if(ml.equals(ml)) {

					if(e.getAction().equals(Action.LEFT_CLICK_AIR)||e.getAction().equals(Action.LEFT_CLICK_BLOCK)||e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

						YmlFile.loadConfig(p.getUniqueId()+" .yml");
						YamlConfiguration c1 = YmlFile.loadConfig(p.getUniqueId()+" .yml");
						if(!c.getBoolean("ok_banned")) {
							e.setCancelled(true);
							c1.set("anti", c.getInt("anti")+1);
							YmlFile.save();
							if(c1.getInt("anti")==5) {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+p.getName()+" du hast zu oft "+p.getItemInHand().getType().toString()+" benutzt");
							} else {
								p.sendMessage(PluginLoader.color("&cDu hast "+p.getItemInHand().getType().toString()+" benutzt, +1 Anti"));
							}
						}
					}
				}
			}
		}
	}
}
