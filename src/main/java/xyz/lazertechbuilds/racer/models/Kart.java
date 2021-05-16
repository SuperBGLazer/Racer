package xyz.lazertechbuilds.racer.models;

import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;

public class Kart {
    private Boat boat;
    private Player player;
    private int laps;
    private double time;
    private double maxTime;
    private Track track;
    private int checkPointNumber;

    public Kart(Boat boat, Player player, int laps, double time, double maxTime, Track track, int checkPointNumber) {
        this.boat = boat;
        this.player = player;
        this.laps = laps;
        this.time = time;
        this.maxTime = maxTime;
        this.track = track;
        this.checkPointNumber = checkPointNumber;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(double maxTime) {
        this.maxTime = maxTime;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public int getCheckPointNumber() {
        return checkPointNumber;
    }

    public void setCheckPointNumber(int checkPointNumber) {
        this.checkPointNumber = checkPointNumber;
    }
}
