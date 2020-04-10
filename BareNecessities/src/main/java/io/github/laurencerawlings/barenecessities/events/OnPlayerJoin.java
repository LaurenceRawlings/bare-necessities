package io.github.laurencerawlings.barenecessities.events;

import io.github.laurencerawlings.barenecessities.BareNecessities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OnPlayerJoin implements Listener {
    private BareNecessities plugin;

    public OnPlayerJoin(BareNecessities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        plugin.getAccountSystem();
    }
}
