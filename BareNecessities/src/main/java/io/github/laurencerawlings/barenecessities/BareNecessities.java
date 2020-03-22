package io.github.laurencerawlings.barenecessities;

import io.github.laurencerawlings.barenecessities.events.BedListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BareNecessities extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Registering events...");
        getServer().getPluginManager().registerEvents(new BedListener(this),
                this);
        getLogger().info("Loaded successfully");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Shutting down successfully");
    }
}
