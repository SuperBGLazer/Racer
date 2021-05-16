package xyz.lazertechbuilds.racer.models;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Track {
    private String name;
    private int maxPlayers;
    private int minPlayers;
    private int maxLaps;

    private final Map<Player, Kart> karts = new HashMap<>();

    public Track(String name, int minPlayers, int maxPlayers, int maxLaps) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.maxLaps = maxLaps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxLaps() {
        return maxLaps;
    }

    public void setMaxLaps(int maxLaps) {
        this.maxLaps = maxLaps;
    }

    public Map<Player, Kart> getKarts() {
        return karts;
    }

    public void addKart(Kart kart) {
        karts.put(kart.getPlayer(), kart);
    }

    public void startRace() {

    }

}
