package com.citrizz.custominventoriesmcplugintutorial;

import com.citrizz.custominventoriesmcplugintutorial.commands.TutorialCommands;
import com.citrizz.custominventoriesmcplugintutorial.events.InventoryEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("selectionscreen").setExecutor(new TutorialCommands());
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
    }

    @Override
    public void onDisable() {

    }
}
