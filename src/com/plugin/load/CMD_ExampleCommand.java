package com.plugin.load;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;

public class CMD_ExampleCommand extends CoderCommand {

	public CMD_ExampleCommand(String name) {
		super(name);
		//Beschreibung des Commands
		description = "Beispiel";
		//Nutzung des Commands
		usageMessage = "/"+name;
		//Permission des Commands
		setPermission("coder.examp");
	}

	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		//Der Sender als Spieler
		Player sender = (Player)arg0;
		//Überprüfung auf die Permission
		if(hasPermission(sender)) {
			//Überprüfung der Argumente
			if(args.length<1) {
				//Erfolgreich
				msg(sender, "Erfolgreich!");
				return true;
			}
		}
		return false;
	}

}
