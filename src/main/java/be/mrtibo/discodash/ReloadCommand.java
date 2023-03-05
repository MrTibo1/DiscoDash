package be.mrtibo.discodash;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    DiscoDash main;

    public ReloadCommand(DiscoDash main){
        this.main = main;
        main.getCommand("discodash").setExecutor(this);
        main.getLogger().info("Reload command set");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        main.joinListener.updateSettings();
        sender.sendMessage(Component.text("Setings reloaded").color(TextColor.color(79, 255, 61)));
        return true;

    }
}
