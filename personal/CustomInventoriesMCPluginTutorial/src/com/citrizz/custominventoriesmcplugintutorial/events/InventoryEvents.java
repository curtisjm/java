package com.citrizz.custominventoriesmcplugintutorial.events;

import com.citrizz.custominventoriesmcplugintutorial.inventories.SelectionScreen;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvents implements Listener {

    // prevents players from taking item out of inventory
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getClickedInventory() == null) { return; }
        if(event.getClickedInventory().getHolder() instanceof SelectionScreen) {
            event.setCancelled(true);
            if(event.isLeftClick()) {
                Player player = (Player) event.getWhoClicked();
                if(event.getCurrentItem() == null) { return; }
                if(event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                    player.sendMessage(ChatColor.GREEN + "You have selected the 'accept' button");
                    player.closeInventory();
                }
                else if( event.getSlot() == 4) {
                    player.sendMessage(ChatColor.AQUA + "Please make a selection... I don't have all day");
                }
                else if(event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                    player.sendMessage(ChatColor.RED + "You have selected the 'deny' button");
                    player.closeInventory();
                }
            }
        }
    }
}
