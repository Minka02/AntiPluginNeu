package com.plugin.load;

import com.coder.client.main.YmlFile;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config
{
  public void cfgGen()
  {
    YmlFile.setAllPath("ehd/Anti");
    YamlConfiguration c = YmlFile.loadConfig("config.yml");
    if (!YmlFile.configExists("config.yml")) {
      YmlFile.generateConfig("config.yml");
      c.set("Prefix", true);
      YmlFile.save();
    }
    if(!YmlFile.configExists("messages.yml")) {
    	YmlFile.generateConfig("messages.yml");
    	YamlConfiguration cc = YmlFile.loadConfig("messages.yml");

    	YmlFile.save();
    }
  }
}