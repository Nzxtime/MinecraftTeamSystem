package de.laserlord.minecraft.teamsystem;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private String prefix;
    private List<Player> playerList;
    private Color teamColor;
    private int maxTeamSize;

    public Team(String teamName, String prefix, Color teamColor) {
        this.teamName = teamName;
        this.prefix = prefix;
        this.teamColor = teamColor;
        this.playerList = new ArrayList<Player>();
    }

    public Team(String teamName, String prefix) {
        this.teamName = teamName;
        this.prefix = prefix;
        this.playerList = new ArrayList<Player>();
    }

    public Team(String teamName) {
        this.teamName = teamName;
        this.prefix = teamName;
        this.playerList = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        if (!playerList.contains(player)) {
            playerList.add(player);
            setPlayerPrefix(player);
        }
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }

    public void sendMessageToTeam(Player sender, String message) {
        for (Player player : playerList) {
            if (!player.getUniqueId().equals(sender.getUniqueId())) {
                player.sendMessage(message);
            }
        }
    }

    public void setPlayerPrefix(Player player) {
        player.setDisplayName(this.teamColor + "[" + prefix + "] " + Color.WHITE + player.getName());
    }

    public void removePlayerPrefix(Player player) {
        player.setDisplayName(player.getName());
    }


    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<String> getPlayerNameList() {
        List<String> playerNamesList = new ArrayList<String>();
        for (Player player : playerList) {
            playerNamesList.add(player.getName());
        }
        return playerNamesList;
    }

    public Color getTeamColor() {
        return teamColor;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void setTeamColor(Color teamColor) {
        this.teamColor = teamColor;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(int maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }
}
