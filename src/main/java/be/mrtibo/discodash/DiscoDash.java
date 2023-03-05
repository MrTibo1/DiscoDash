package be.mrtibo.discodash;

import org.bukkit.plugin.java.JavaPlugin;

public final class DiscoDash extends JavaPlugin {


    JoinListener joinListener;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        joinListener = new JoinListener(this);
        new ReloadCommand(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
