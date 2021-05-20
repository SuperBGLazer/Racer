package xyz.lazertechbuilds.racer.models;

import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.lazertechbuilds.racer.Racer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Track {
    private String name;
    private TrackType trackType;
    private int maxPlayers;
    private int minPlayers;
    private int maxLaps;
    private final ArrayList<Location> lobbyLocations = new ArrayList<>();
    private final ArrayList<Location> gridLocations = new ArrayList<>();

    private final Map<Player, Kart> karts = new HashMap<>();

    public Track(String name, TrackType trackType, int minPlayers, int maxPlayers, int maxLaps) {
        this.name = name;
        this.trackType = trackType;
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

    public TrackType getTrackType() {
        return trackType;
    }

    public void setTrackType(TrackType trackType) {
        this.trackType = trackType;
    }

    public ArrayList<Location> getLobbyLocations() {
        return lobbyLocations;
    }

    public ArrayList<Location> getGridLocations() {
        return gridLocations;
    }

    public Map<Player, Kart> getKarts() {
        return karts;
    }

    public void addKart(Kart kart) {
        karts.put(kart.getPlayer(), kart);
    }

    public void startRace() {

    }

    public void save() throws IOException {
        File file = new File(Racer.getPlugin(Racer.class).getDataFolder(), this.name + ".yml");
        YamlConfiguration configuration = new YamlConfiguration();
        configuration.set("name", this.name);
        configuration.set("track-type", this.trackType.toString());
        configuration.set("max-laps", this.maxLaps);
        configuration.set("max-players", this.maxPlayers);
        configuration.set("min-players", this.minPlayers);
        configuration.set("grid-locations", this.gridLocations);
        configuration.set("lobby-locations", this.lobbyLocations);

        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }

        configuration.save(file);
    }

    public static Track getFromFile(File file) throws IOException, InvalidConfigurationException {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.load(file);
        String name = yamlConfiguration.getString("name");
        TrackType trackType = TrackType.fromString(yamlConfiguration.getString("track-type"));
        int minPlayers = yamlConfiguration.getInt("min-players");
        int maxPlayers = yamlConfiguration.getInt("max-players");
        int laps = yamlConfiguration.getInt("max-laps");
        List<?> lobbyLocations = yamlConfiguration.getList("lobby-locations");
        List<?> gridLocations = yamlConfiguration.getList("grid-locations");

        Track track = new Track(name, trackType, minPlayers, maxPlayers, laps);
        for (Object obj :
                lobbyLocations) {
            track.getLobbyLocations().add((Location) obj);
        }

        for (Object obj :
                gridLocations) {
            track.getGridLocations().add((Location) obj);
        }

        return track;
    }

}
