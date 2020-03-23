package io.github.laurencerawlings.barenecessities;

import io.github.laurencerawlings.barenecessities.commands.God;
import io.github.laurencerawlings.barenecessities.events.OnPlayerSleep;
import io.github.laurencerawlings.barenecessities.models.Account;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

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

        //Load
        Configuration config = getConfig();
        config.options().copyDefaults();
        saveDefaultConfig();

        //Read
        //General


        //Single Player Sleep
        if (config.getBoolean("early-wakeup-time")) {
            OnPlayerSleep.WAKEUP_TIME = 23000;
        } else {
            OnPlayerSleep.WAKEUP_TIME = 0;
        }
        OnPlayerSleep.WAKEUP_DELAY = config.getInt("wakeup-delay");
        OnPlayerSleep.RANDOM_SLEEP_MESSAGES = config.getBoolean("random-sleep-messages");
        OnPlayerSleep.SLEEP_MESSAGE_COLOR = ChatColor.valueOf(Objects.requireNonNull(config.getString("sleep-message-color")).toUpperCase());
        for (String message : config.getStringList("sleep-messages")) {
            OnPlayerSleep.SLEEP_MESSAGES.add(message.replaceAll("<player>", "%s"));
        }

        //Homes


        //Economy
        Account.STARTING_BALANCE = config.getDouble("starting-balance");
    }

    private void registerEvents() {
        getLogger().info("Registering events...");
        getServer().getPluginManager().registerEvents(new OnPlayerSleep(this), this);
    }

    private void registerCommands() {
        getLogger().info("Registering commands...");
        Objects.requireNonNull(getCommand("god")).setExecutor(new God(this));
    }
}
