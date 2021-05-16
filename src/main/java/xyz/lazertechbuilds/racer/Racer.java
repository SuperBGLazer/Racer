package xyz.lazertechbuilds.racer;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.lazertechbuilds.racer.models.Track;

import java.util.HashMap;

public final class Racer extends JavaPlugin {
    public static final HashMap<String, Track> tracks = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
