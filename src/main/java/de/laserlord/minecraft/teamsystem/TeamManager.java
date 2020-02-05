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
    private int maxDefaultTeamSize = 0;

    public TeamManager(Plugin plugin) {
        this.teamList = new ArrayList<Team>();
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

    public int getNextTeam() {
        int teamnumber = 0;
        for (Team team : teamList) {
            if (team.getTeamName().startsWith("#")) {
                if (Integer.parseInt(team.getTeamName().substring(1)) > teamnumber) {
                    teamnumber = Integer.parseInt(team.getTeamName().substring(1));
                }
            }
        }
        return teamnumber + 1;
    }

    public void registerTeam(String teamName, String prefix, Color color) {
        addTeamAndFillDefaultSettings(new Team(teamName, prefix, color));
    }

    public void registerTeam(String teamName, String prefix) {
        addTeamAndFillDefaultSettings(new Team(teamName, prefix));
    }

    public void registerTeam(String teamName) {
        addTeamAndFillDefaultSettings(new Team(teamName));
    }

    public void registerTeam() {
        addTeamAndFillDefaultSettings(new Team("#" + getNextTeam()));
    }

    public void addTeamAndFillDefaultSettings(Team team) {
        team.setMaxTeamSize(this.maxDefaultTeamSize);
        teamList.add(team);
    }

    public int getMaxDefaultTeamSize() {
        return maxDefaultTeamSize;
    }

    public void setMaxDefaultTeamSize(int maxDefaultTeamSize) {
        this.maxDefaultTeamSize = maxDefaultTeamSize;
    }
}
