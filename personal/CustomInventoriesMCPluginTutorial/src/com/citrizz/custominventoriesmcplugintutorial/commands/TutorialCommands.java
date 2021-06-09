package com.citrizz.custominventoriesmcplugintutorial.commands;

import com.citrizz.custominventoriesmcplugintutorial.inventories.SelectionScreen;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TutorialCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }
        Player player = (Player) sender ;
        if(cmd.getName().equalsIgnoreCase("selectionscreen")) {
            SelectionScreen gui = new SelectionScreen();
            player.openInventory(gui.getInventory());
            player.sendMessage(ChatColor.AQUA + "Please make a selection");
        }

        return true;
    }
}
