package com.citrizz.myplugin;

import com.citrizz.myplugin.commands.ItemCommands;
import com.citrizz.myplugin.commands.MyCommands;
import com.citrizz.myplugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //MyCommands myCmds = new MyCommands();
        ItemCommands itemCmds = new ItemCommands();
        ItemManager.init();
        getCommand("supersmacker").setExecutor(itemCmds);
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[CitrizzPlugin]: enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[CitrizzPlugin]: disabled");
    }
}
