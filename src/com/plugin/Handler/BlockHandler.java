package com.plugin.Handler;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class BlockHandler implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Material m = e.getBlock().getType();
		Player p = e.getPlayer();
		
	    YmlFile.setAllPath("ehd/Anti");
	    YamlConfiguration c = YmlFile.loadConfig("block.yml");
		if(!p.isOp()) {
			
			List<String> blocks = c.getStringList("blocks");
			for(String block : blocks) {
				Material ml = Material.getMaterial(block);
				if(m.equals(ml)) {
				
				    YmlFile.setAllPath("ehd/Anti");
					YmlFile.loadConfig(p.getUniqueId().toString() + ".yml");
					YamlConfiguration c1 = YmlFile.loadConfig(p.getUniqueId().toString() + ".yml");
					if(!c.getBoolean("ok_banned")) {
						c1.set("anti", c1.getInt("anti")+1);
						YmlFile.save();
					p.sendMessage(PluginLoader.color("&cDu hast 1 &4"+e.getBlock().getType().toString()+"&c gesetst, +1 Anti"));
					e.setCancelled(true);
					e.getBlock().setType(Material.AIR);
					if(c1.getInt("anti")>=5) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+p.getName()+" zu oft verbotene Blocks gesetzt ");
					
					}
					}
				}
			}
		}
	}

}
