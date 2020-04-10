package io.github.laurencerawlings.barenecessities.systems;

import io.github.laurencerawlings.barenecessities.BareNecessities;
import io.github.laurencerawlings.barenecessities.models.Account;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class AccountSystem {
    private ArrayList<Account> accounts;
    private JavaPlugin plugin;


    public AccountSystem() {
        accounts = new ArrayList<>();
        plugin = BareNecessities.getPlugin();
    }

    public boolean findAccount(UUID uuid) {
        return accounts.contains(uuid);
    }

    public void addAccount(Player player) {
        accounts.add(new Account(player));
    }
}
