package io.github.laurencerawlings.barenecessities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {

    public God() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                toggleGod((Player) sender);
                return true;
            } else if (args.length == 1) {
                Player target  = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    toggleGod(target);
                } else {
                    sender.sendMessage(ChatColor.RED + "Player not found");
                }
                return true;
            }
        }
        return false;
    }

    public static void toggleGod(Player player) {
        if (player.isInvulnerable()) {
            disableGod(player);
        } else {
            enableGod(player);
        }
    }

    public static void enableGod(Player player) {
        if (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE) {
            player.setInvulnerable(true);
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage("God mode enabled");
        }
    }

    public static void disableGod(Player player) {
        if (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE) {
            player.setInvulnerable(false);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage("God mode disabled");
        }
    }
}
