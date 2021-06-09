package com.citrizz.tutorial.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class TutorialCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command");
            return true;
        }
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("heal2")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage("§e You have been healed!");
        }
        else if(cmd.getName().equalsIgnoreCase("feed2")) {
            player.setFoodLevel(20);
            player.sendMessage("§e You have been fed!");
        }

        // ex: /farmtime cow 5
        else if(cmd.getName().equalsIgnoreCase("farmtime")) {
            if(args.length >= 2) {
                try {
                    // toUpperCase
                    // allows lowercase inputs
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);
                    for(int i=0; i<amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } catch (IllegalArgumentException e) {
                    player.sendMessage("§cInvalid entity");
                }
            } else {
                player.sendMessage("§c/farmtime <mob> <amount>");
            }
        }

        // always return true
        return true;
    }
}
