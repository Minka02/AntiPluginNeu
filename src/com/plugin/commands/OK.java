package com.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class OK extends CoderCommand {

	public OK(String name) {
		super(name);
	}

	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		Player sender = senderToPlayer(arg0);

		if(Bukkit.getServer().getPlayer(args[0])!=null) {
			Player target = sender.getServer().getPlayer(args[0]);
			YmlFile.setAllPath("ehd/Anti/Player");
			YamlConfiguration c = YmlFile.loadConfig(sender.getUniqueId()+" .yml");
			sender.sendMessage(PluginLoader.color("&eDer Spiler hat &aok "));
			c.set("ok", "t");
			YmlFile.save();

			return true;
		} else {
			sender.sendMessage(PluginLoader.color("&4Der Spieler &c"+args[1]+" &4ist nicht Online!"));
			//return true;
		}
		
		return false;
	}

}
