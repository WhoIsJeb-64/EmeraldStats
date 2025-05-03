package org.emc.stats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.emc.stats.data.EmPlayer;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.emc.stats.data.EmPlayer.*;

public class Listener implements org.bukkit.event.Listener {
    private EmeraldStats plugin;

    public Listener(EmeraldStats plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerJoin(final PlayerJoinEvent event) throws IOException, ParseException {
        String playerName = event.getPlayer().getName();

        //Checks if player is already registered with the plugin; if not, register them.
        plugin.PlayerMap().registerPlayer(playerName);
        try {
            EmPlayer player = plugin.PlayerMap().getPlayer(playerName);
        } catch (Exception e) {
            EmPlayer player = plugin.PlayerMap().loadPlayer(playerName);
        }

    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockBreak(final BlockBreakEvent event) {
        String playerName = event.getPlayer().getName();
        EmPlayer player = plugin.PlayerMap().getPlayer(playerName);
        int blocksBroken = getBlocksBroken(player) + 1;
        setBlocksBroken(player, blocksBroken);
    }
}
