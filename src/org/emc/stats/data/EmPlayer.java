package org.emc.stats.data;

import org.json.simple.JSONObject;
import org.emc.stats.EmeraldStats;

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

    //Create JSON for player
    public JSONObject getJsonObject() {
        JSONObject obj = new JSONObject();

        obj.put("name", this.name);
        obj.put("firstJoin", this.firstJoin);
        obj.put("blocksBroken", this.blocksBroken);
        obj.put("blocksPlaced", this.blocksPlaced);
        obj.put("messagesSent", this.messagesSent);

        return obj;
        }

    //Getters
    public boolean isModified() {
        return modified;
    }

    public String getName() {
        return name;
    }

    public Date getFirstJoin() {
        return new Date(this.firstJoin);
    }

    public int getBlocksBroken() {
        if (plugin.PlayerMap().getKnownPlayers().contains(name)) {
            EmPlayer player = plugin.PlayerMap().getPlayer(name);
            return player.blocksBroken;
        }
        return 0;
    }
    public int getBlocksPlaced() {
        if (plugin.PlayerMap().getKnownPlayers().contains(name)) {
            EmPlayer player = plugin.PlayerMap().getPlayer(name);
            return player.blocksPlaced;
        }
        return 0;
    }
    public int getMessagesSent() {
        if (plugin.PlayerMap().getKnownPlayers().contains(name)) {
            EmPlayer player = plugin.PlayerMap().getPlayer(name);
            return player.messagesSent;
        }
        return 0;
    }

    //Setters and Incrementers
}
