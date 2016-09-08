package com.plugin.Handler;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingHandler implements Listener {
	
	
	@EventHandler
	public void onItemCraft(CraftItemEvent e) {
		ItemStack is = e.getRecipe().getResult();
		if(is.getType().equals(Material.FIREBALL)||is.getType().equals(Material.DISPENSER)) {
			e.setCancelled(true);
		}
	}
}
