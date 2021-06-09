package com.citrizz.customitemsmcplugintutorial;

import com.citrizz.customitemsmcplugintutorial.commands.TutorialCommands;
import com.citrizz.customitemsmcplugintutorial.events.TutorialEvents;
import com.citrizz.customitemsmcplugintutorial.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        getCommand("givewand").setExecutor(new TutorialCommands());
    }

    @Override
    public void onDisable() { }

}
