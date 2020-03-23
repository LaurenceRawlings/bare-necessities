package io.github.laurencerawlings.barenecessities;

import io.github.laurencerawlings.barenecessities.commands.*;
import io.github.laurencerawlings.barenecessities.events.*;
import io.github.laurencerawlings.barenecessities.tasks.SleepTask;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public final class BareNecessities extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfig();
        registerCommands();
        registerEvents();
        getLogger().info("Loaded successfully");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Shut down successfully");
    }

    private void loadConfig() {
        getLogger().info("Loading config...");
        Configuration config = getConfig();
        config.options().copyDefaults();
        saveDefaultConfig();

        if (config.getBoolean("early-wakeup-time")) {
            OnPlayerSleep.WakeUp = 23000;
        } else {
            OnPlayerSleep.WakeUp = 0;
        }

        OnPlayerSleep.Delay = config.getInt("wakeup-delay");
        OnPlayerSleep.RandomMessages = config.getBoolean("random-sleep-messages");
        OnPlayerSleep.MessageColor = ChatColor.valueOf(config.getString("sleep-message-color").toUpperCase());
    }

    private void registerEvents() {
        getLogger().info("Registering events...");
        getServer().getPluginManager().registerEvents(new OnPlayerSleep(this), this);
    }

    private void registerCommands() {
        getLogger().info("Registering commands...");
        getCommand("god").setExecutor(new God(this));
    }
}
