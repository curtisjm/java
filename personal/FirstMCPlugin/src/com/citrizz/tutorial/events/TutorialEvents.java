package com.citrizz.tutorial.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

// make death cords

public class TutorialEvents implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.DARK_PURPLE + "I'M WATCHING YOU ;)");
    }

    /*
    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent event ) {
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        // y - 1 bc/ need block below player
        Material block = player.getWorld().getBlockAt(x, y-1, z).getType();
        switch(block) {
            case GRASS_BLOCK: player.sendMessage("You are standing on a grass block");
                break;
            case STONE: player.sendMessage("You are standing on stone");
                break;
        }
    }
     */

}
