package com.plugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.plugin.load.PluginLoader;

public class Info_ingame extends CoderCommand{

	public Info_ingame(String name) {
		super(name);
		description = "Zeigt dir Infos vom Plugin";
		usageMessage = "/";
		setPermission("anti.info");
	}

	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		Player p = senderToPlayer(arg0);
			if (hasPermission(p) || p.isOp()&&args.length ==0) {
				msg(p, PluginLoader.color("&aSeite 1/3 "));
				msg(p, PluginLoader.color("&aName: AntiPlugin "));
				msg(p, PluginLoader.color("&aVersion: 0.1 "));
				msg(p, PluginLoader.color("&a1Autor: Minka_H "));
				msg(p, PluginLoader.color("&a2Autor: Duck_c "));
				
					return true;
			}
			
		     if(((hasPermission(p))||(p.isOp()))&&(args.length==1)) {
		    	 if(args[0].equals("1")) {
		    		 msg(p, PluginLoader.color("&aSeite 1/3"));
		    		 msg(p, PluginLoader.color("&c[Achtung] &aMan kann das <ap> vor dem Befell Ein und Aus schalten!!"));
		    		 msg(p, PluginLoader.color("&b/<ap> "));
		    		 msg(p, PluginLoader.color("&b/<ap> "));
		    		 msg(p, PluginLoader.color("&b/<ap> "));
		    		 msg(p, PluginLoader.color("&b/<ap> "));
		    		 msg(p, PluginLoader.color("&b/<ap> "));
		    		 msg(p, PluginLoader.color("&c[Achtung] &aBitte einfach Testen ob mit oder ohne <m> geht!!"));
		    	 
		    		 	return true;
		    	 }
		     
		     	
			}
		
		return false;
	}
	
}
