package io.github.laurencerawlings.barenecessities.events;

import io.github.laurencerawlings.barenecessities.BareNecessities;
import io.github.laurencerawlings.barenecessities.tasks.SleepTask;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
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
    Map<Player, SleepTask> sleepTasks = new HashMap();

    public OnPlayerSleep(BareNecessities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();

        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            String message = String.format(getMessage(), event.getPlayer().getDisplayName());
            plugin.getServer().broadcastMessage(message);
            SleepTask sleepTask = new SleepTask(player);
            sleepTask.runTaskLater(plugin, Delay * 20L);
            sleepTasks.put(player, sleepTask);
        }
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        SleepTask sleepTask = sleepTasks.get(event.getPlayer());
        if (sleepTask != null) {
            sleepTask.setCancelled(true);
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
