package io.github.laurencerawlings.barenecessities.systems;

import io.github.laurencerawlings.barenecessities.BareNecessities;
import io.github.laurencerawlings.barenecessities.models.Account;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class AccountSystem {
    private ArrayList<Account> accounts;
    private JavaPlugin plugin;


    public AccountSystem() {
        accounts = new ArrayList<>();
        plugin = BareNecessities.getPlugin();
    }
}
