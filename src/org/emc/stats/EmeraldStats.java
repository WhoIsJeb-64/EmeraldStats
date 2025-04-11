package org.emc.stats;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.emc.stats.commands.StatsCommand;
import org.emc.stats.data.PlayerMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmeraldStats extends JavaPlugin {
    private JavaPlugin plugin;
    private Logger log;
    private PlayerMap playerMap;

    @Override
    public void onEnable() {
        plugin = this;
        log = this.getServer().getLogger();
        playerMap = new PlayerMap(this);

        getCommand("stats").setExecutor(new StatsCommand(this));

        Listener listener = new Listener(this);

        log.info("EmeraldStats has loaded!");
    }

    @Override
    public void onDisable() {
        playerMap.saveData();
        log.info("EmeraldStats has unloaded!");
    }

    public PlayerMap PlayerMap() {
        return playerMap;
    }

    public void getLogger(Level warning, String s) {

    }

    public void sendMessage(CommandSender sender, String message) {
        message = message.replace("&", "§");
        String[] lines = message.split("\\n");
        for (String line : lines) {
            sender.sendMessage(line);
        }
    }
}