package org.emc.stats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listener implements org.bukkit.event.Listener {
    private EmeraldStats plugin;

    public Listener(EmeraldStats emeraldStats) {
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerJoin(final PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();

        //Checks if player is already registered with the plugin; if not, register them.
        plugin.PlayerMap().registerPlayer(playerName);
    }
}
