package io.github.laurencerawlings.barenecessities.tasks;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static io.github.laurencerawlings.barenecessities.events.OnPlayerSleep.WAKEUP_TIME;

public class SleepTask extends BukkitRunnable {
    private Player player;
    private boolean cancelled;

    public SleepTask(Player player) {
        this.player = player;
        cancelled = false;
    }

    @Override
    public void run() {
        if (!cancelled) {
            player.getWorld().setTime(WAKEUP_TIME);
            player.teleport(player.getBedLocation());
        } else {
            this.cancel();
        }
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
