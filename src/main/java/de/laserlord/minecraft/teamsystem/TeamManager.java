package de.laserlord.minecraft.teamsystem;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private Plugin plugin;
    private List<Team> teamList;
    private boolean prefix;

    public TeamManager(Plugin plugin) {
        teamList = new ArrayList<Team>();
        this.plugin = plugin;
        this.prefix = true;
    }

    public boolean isPrefix() {
        return prefix;
    }

    public void setPrefix(boolean prefix) {
        this.prefix = prefix;
    }

    public Team getTeamByPlayer(Player player) {
        for (Team team : teamList) {
            if (team.getPlayerList().contains(player)) {
                return team;
            }
        }
        return null;
    }

    public Team getTeamByName(String teamName) {
        for (Team team : teamList) {
            if (team.getTeamName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }

    public void registerTeam(String teamName, String prefix, Color color) {
        teamList.add(new Team(teamName, prefix, color));
    }

    public void registerTeam(String teamName, String prefix) {
        teamList.add(new Team(teamName, prefix));
    }

    public void registerTeam(String teamName) {
        teamList.add(new Team(teamName));
    }
}
