package io.github.laurencerawlings.barenecessities.events;

import io.github.laurencerawlings.barenecessities.BareNecessities;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.Random;

public class OnPlayerSleep implements Listener {
    public static long WakeUp = 0;
    public static long Delay = 5;
    public static boolean RandomMessages = true;
    public static ChatColor MessageColor = ChatColor.YELLOW;

    public static String[] Messages = new String[]{
            "Ssh, %s is sleeping...",
            "%s has gone to bed."
    };

    BareNecessities plugin;

    public OnPlayerSleep(BareNecessities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();

        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            String message = String.format(getMessage(),
                    event.getPlayer().getDisplayName());
            plugin.getServer().broadcastMessage(message);
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
                    () -> player.getWorld().setTime(WakeUp),
                    Delay * 20L);
        }
    }

    private String getMessage() {
        int i = 0;
        if (RandomMessages) {
            i = new Random().nextInt(Messages.length);
        }
        return MessageColor + Messages[i];
    }
}
