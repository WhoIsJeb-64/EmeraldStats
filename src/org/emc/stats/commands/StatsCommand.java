package org.emc.stats.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.emc.stats.EmeraldStats;
import org.emc.stats.data.EmPlayer;

import static org.emc.stats.data.EmPlayer.*;

public class StatsCommand implements CommandExecutor {
    private EmeraldStats plugin;

    public StatsCommand(EmeraldStats plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        EmPlayer player = plugin.PlayerMap().getPlayer(sender.getName());
        if (!sender.hasPermission("emeraldstats.stats") && !sender.isOp()) {
            plugin.sendMessage(sender, "&4» &7You do not have permission to execute &c/stats");
            return true;
        }
        plugin.sendMessage(sender, "&2" + sender.getName() + "'s &astatistics:" +
                "\n========================================" +
                "\n&7» &4First Join: &c" + getFirstJoin(player) +
                "\n&7» &6Blocks broken/placed: &e" + getBlocksBroken(player) + "/" + getBlocksPlaced(player) +
                "\n&7» &2Messages sent: &a" + getMessagesSent(player));
        return true;
    }
}
