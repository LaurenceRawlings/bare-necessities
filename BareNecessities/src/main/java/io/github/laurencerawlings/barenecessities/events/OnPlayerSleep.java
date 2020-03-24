package io.github.laurencerawlings.barenecessities.events;

import io.github.laurencerawlings.barenecessities.BareNecessities;
import io.github.laurencerawlings.barenecessities.tasks.SleepTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class OnPlayerSleep implements Listener {
    public static long WAKEUP_TIME = 0;
    public static long WAKEUP_DELAY = 5;
    public static boolean RANDOM_SLEEP_MESSAGES = true;
    public static ChatColor SLEEP_MESSAGE_COLOR = ChatColor.YELLOW;

    public static List<String> SLEEP_MESSAGES = new ArrayList<>();

    private Map<Player, SleepTask> sleepTasks = new HashMap<>();

    public OnPlayerSleep() {
        if (SLEEP_MESSAGES.size() == 0) {
            SLEEP_MESSAGES.add("%s is sleeping");
        }
    }

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();

        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            String message = String.format(getMessage(), event.getPlayer().getDisplayName());
            Bukkit.broadcastMessage(message);
            SleepTask sleepTask = new SleepTask(player);
            sleepTask.runTaskLater(BareNecessities.getPlugin(), WAKEUP_DELAY * 20L);
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
        if (RANDOM_SLEEP_MESSAGES) {
            i = new Random().nextInt(SLEEP_MESSAGES.size());
        }
        return SLEEP_MESSAGE_COLOR + SLEEP_MESSAGES.get(i);
    }
}
