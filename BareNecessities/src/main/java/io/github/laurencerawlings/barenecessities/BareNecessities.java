package io.github.laurencerawlings.barenecessities;

import io.github.laurencerawlings.barenecessities.commands.*;
import io.github.laurencerawlings.barenecessities.events.*;
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
        getConfig().options().copyDefaults();
        saveDefaultConfig();
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
