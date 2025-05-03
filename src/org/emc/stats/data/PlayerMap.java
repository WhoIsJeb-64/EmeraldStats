package org.emc.stats.data;

import org.emc.stats.EmeraldStats;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import static org.emc.stats.data.EmPlayer.*;

public class PlayerMap {
    private EmeraldStats plugin;
    private ArrayList<String> knownPlayers = new ArrayList<>();
    private HashMap<String, EmPlayer> playerMap = new HashMap<>();

    public PlayerMap(EmeraldStats plugin) {
        this.plugin = plugin;
        File dataDir = new File(plugin.getDataFolder(), "statistics");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }

    public EmPlayer getPlayer(String name) {
        if (knownPlayers.contains(name)) {
            EmPlayer player = playerMap.get(name);
        }
        return null;
    }

    public void registerPlayer(String playerName) throws IOException, ParseException {
        EmPlayer player;
        if (!(getKnownPlayers().contains(playerName))) {
            player = new EmPlayer(playerName, System.currentTimeMillis(), 0, 0, 0);
            //savePlayer(player);
        } else {
            //
        }
        getKnownPlayers().add(playerName);
        getPlayerMap().put(playerName, player);
    }

    public ArrayList<String> getKnownPlayers() {
        return knownPlayers;
    }

    public HashMap<String, EmPlayer> getPlayerMap() {
        return playerMap;
    }
}
