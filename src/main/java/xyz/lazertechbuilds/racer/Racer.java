package xyz.lazertechbuilds.racer;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.lazertechbuilds.racer.commands.*;
import xyz.lazertechbuilds.racer.models.Track;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class Racer extends JavaPlugin {
    public static final HashMap<String, Track> TRACKS = new HashMap<>();
    public static final String VERSION = "1.0";
    public static FileConfiguration configuration;

    @Override
    public void onEnable() {
        // Add commands
        new CreateTrackCommand(this);
        new ListTracksCommand(this);
        new AddGridPos(this);
        new AddLobbyPos(this);
        new StartRaceCommand(this);
        new ClearGridPos(this);
        new ClearLobbyPos(this);
        new JoinGame(this);

        try {
            saveLoadDefaultConfig();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void saveLoadDefaultConfig() throws IOException, InvalidConfigurationException {
        File configFile = new File(getDataFolder(), "config.yml");
        if (configuration == null) {
            getConfig().load(configFile);
            configuration = getConfig();
            for (Object obj :
                    configuration.getList("tracks")) {
                String trackName = (String) obj;
                File file = new File(getDataFolder(), trackName + ".yml");
                Track track = Track.getFromFile(file);
                TRACKS.put(trackName, track);
            }

        } else {
            getConfig().set("tracks", TRACKS.keySet().toArray());
            getConfig().save(configFile);
        }
    }

}
