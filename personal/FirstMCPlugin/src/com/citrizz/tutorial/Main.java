package com.citrizz.tutorial;

import com.citrizz.tutorial.commands.TutorialCommands;
import com.citrizz.tutorial.events.TutorialEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        TutorialCommands commands = new TutorialCommands();
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        getCommand("heal2").setExecutor(commands);
        getCommand("feed2").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Tutorial]: Plugin is enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Tutorial]: Plugin is disabled");
    }
}
