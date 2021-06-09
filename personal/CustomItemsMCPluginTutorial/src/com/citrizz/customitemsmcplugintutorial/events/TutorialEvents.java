package com.citrizz.customitemsmcplugintutorial.events;

import com.citrizz.customitemsmcplugintutorial.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class TutorialEvents implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem() != null) {
                if(event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().createExplosion(player.getLocation(), 5.0f);
                    player.sendMessage("§6Boom!");
                }
            }
        }
    }
}
