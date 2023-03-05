package be.mrtibo.discodash;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinListener implements Listener {

    DiscoDash main;
    String rpUrl;
    String rpHash;

    public JoinListener(DiscoDash main){
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
        main.getLogger().info("Join event registered");
        updateSettings();
    }

    public void updateSettings(){
        this.rpUrl = main.getConfig().getString("url");
        this.rpHash = main.getConfig().getString("hash");
        main.getLogger().info("Resource pack settings updated");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {
                e.getPlayer().setResourcePack(rpUrl, rpHash, !e.getPlayer().hasPermission("*"), Component.text("Please accept the resource pack to start playing!").color(TextColor.color(94, 255, 191)));
            }
        }.runTaskLater(main, 20);
    }

}
