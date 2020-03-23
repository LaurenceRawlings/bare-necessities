package io.github.laurencerawlings.barenecessities.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = (Player) sender;
                boolean current = player.isInvulnerable();
                player.setInvulnerable(!current);
                player.setAllowFlight(!current);
                player.setFlying(!current);
                player.sendMessage("God toggled");
                return true;
            }
        }

        return false;
    }
}
