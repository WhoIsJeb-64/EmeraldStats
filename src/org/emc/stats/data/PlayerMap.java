package org.emc.stats.data;

import org.emc.stats.EmeraldStats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

public class PlayerMap {
    private EmeraldStats plugin;
    private ArrayList<String> knownPlayers = new ArrayList<>();
    private HashMap<String, EmPlayer> playerMap = new HashMap<>();

    public PlayerMap(EmeraldStats emeraldStats) {
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

    public void registerPlayer(String playerName) {
        if (!(getKnownPlayers().contains(playerName))) {
            EmPlayer player = new EmPlayer(playerName, 0, 0, 0, 0);
            getKnownPlayers().add(playerName);
            getPlayerMap().put(playerName, player);
        }
    }

    public ArrayList<String> getKnownPlayers() {
        return knownPlayers;
    }

    public HashMap<String, EmPlayer> getPlayerMap() {
        return playerMap;
    }

    public void saveData() {
        for (EmPlayer player : playerMap.values()) {
            if (player.isModified()) {
                savePlayer(player);
            }
        }
    }

    void savePlayer(EmPlayer player) {
        //Save to JSON
        File fileO = new File(plugin.getDataFolder(), "statistics" + File.separator + player.getName() + ".json");
        try (FileWriter file = new FileWriter(fileO)) {
            file.write(player.getJsonObject().toJSONString());
            file.flush();
        } catch (IOException e) {
            plugin.getLogger(Level.WARNING,  "Failed to create JSON for " + player.getName());
            e.printStackTrace();
        }
    }
}
