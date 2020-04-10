package io.github.laurencerawlings.barenecessities.models;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Account {
    public static double STARTING_BALANCE = 0;

    private UUID uuid;
    private String lastAccountName;
    private InetSocketAddress ip;
    private Location logoutLocation;
    private Location lastLocation;
    private boolean afk;
    private double balance;
    private ArrayList<Home> homes;

    public Account(Player player) {
        this.uuid = player.getUniqueId();
        this.lastAccountName = player.getDisplayName();
        this.ip = player.getAddress();
        this.afk = false;
        this.balance = STARTING_BALANCE;
        this.homes = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof UUID) return  uuid.equals(o);
        if (getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return uuid.equals(account.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
