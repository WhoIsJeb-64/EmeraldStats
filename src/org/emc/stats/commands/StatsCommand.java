package org.emc.stats.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.emc.stats.EmeraldStats;
import org.emc.stats.data.EmPlayer;

public class StatsCommand implements CommandExecutor {
    private EmeraldStats plugin;

    public StatsCommand(EmeraldStats plugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "among us");
        EmPlayer player = plugin.PlayerMap().getPlayer(sender.getName());
        plugin.sendMessage(sender, "&2" + sender.getName() + "'s &astatistics:" +
                "\n========================================" +
                "\n&7» &4First Join: &c" + player.getFirstJoin() +
                "\n&7» &6Blocks broken/placed: &e" + player.getBlocksBroken() + "/" + player.getBlocksPlaced() +
                "\n&7» &2Messages sent: &a" + player.getMessagesSent());
        return true;
    }
}
