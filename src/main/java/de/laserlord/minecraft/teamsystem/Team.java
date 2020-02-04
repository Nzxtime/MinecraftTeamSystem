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
        playerList.add(player);
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }


    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayerList() {
        return playerList;
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
}
