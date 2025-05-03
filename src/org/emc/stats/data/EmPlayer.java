package org.emc.stats.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.json.simple.JSONObject;
import org.emc.stats.EmeraldStats;
import org.json.simple.JSONValue;

import java.util.Date;

public class EmPlayer {
    private EmeraldStats plugin;
    private boolean modified = false;

    private String name;
    private long firstJoin;
    private int blocksBroken;
    private int blocksPlaced;
    private int messagesSent;

    public EmPlayer(String playerName, long firstJoin, int blocksBroken, int blocksPlaced, int messagesSent) {
        this.name = playerName;
        this.firstJoin = firstJoin;
        this.blocksBroken = blocksBroken;
        this.blocksPlaced = blocksPlaced;
        this.messagesSent = messagesSent;
    }

    public void savePlayer() {
        FileConfiguration userFile = plugin.getConfig();

    }

    //Getters
    public static boolean isModified(EmPlayer player) {
        return player.modified;
    }

    public static String getName(EmPlayer player) {
        return player.name;
    }

    public static Date getFirstJoin(EmPlayer player) {
        return new Date(player.firstJoin);
    }

    public static int getBlocksBroken(EmPlayer player) {
        return player.blocksBroken;
    }

    public static int getBlocksPlaced(EmPlayer player) {
        return player.blocksPlaced;
    }
    public static int getMessagesSent(EmPlayer player) {
        return player.messagesSent;
    }

    public static void setBlocksBroken(EmPlayer player, int num) {
        player.modified = true;
        player.blocksBroken = num;
    }
    public static void setBlocksPlaced(EmPlayer player, int num) {
        player.modified = true;
        player.blocksPlaced = num;
    }
    public static void setMessagesSent(EmPlayer player, int num) {
        player.modified = true;
        player.messagesSent = num;
    }
}
