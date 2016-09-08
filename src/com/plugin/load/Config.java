package com.plugin.load;

import com.coder.client.main.YmlFile;

import java.util.Arrays;

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
    
    YmlFile.setAllPath("ehd/Anti");
    if(!YmlFile.configExists("messages.yml")) {
    	YmlFile.generateConfig("messages.yml");
    	YamlConfiguration cc = YmlFile.loadConfig("messages.yml");
    	cc.set("", "msg");
    	YmlFile.save();
    }
    
    YmlFile.setAllPath("ehd/Anti");
    if(!YmlFile.configExists("block.yml")) {
    	YmlFile.generateConfig("block.yml");
    	YamlConfiguration c1 = YmlFile.loadConfig("block.yml");
    	String[] blocks = new String[]{"bedrock", "tnt", "dispenser"};
    	c1.set("blocks", Arrays.asList(blocks));
    	YmlFile.save();
    	
    	String[] items = new String[]{"LAVA_BUCKET", "FLINT_AND_STEEL", ""};
    	c1.set("items", Arrays.asList(items));
    	YmlFile.save();

    }
    
  }
}