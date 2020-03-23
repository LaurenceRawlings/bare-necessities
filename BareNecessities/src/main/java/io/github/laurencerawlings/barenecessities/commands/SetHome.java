package io.github.laurencerawlings.barenecessities.commands;

import io.github.laurencerawlings.barenecessities.models.Home;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SetHome implements CommandExecutor {
    private Map<Player, Home> Homes = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        return false;
    }
}
