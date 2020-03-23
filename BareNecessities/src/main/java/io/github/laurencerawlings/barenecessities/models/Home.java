package io.github.laurencerawlings.barenecessities.models;

import org.bukkit.Location;

import java.util.Objects;

public class Home {
    private String name;
    private Location location;

    public Home(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return name.equals(home.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
