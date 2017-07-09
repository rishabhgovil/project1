package com.example.rishabh.gettinbored.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class matches  {
    Integer unique_id;
    String date;
    String squad;
    @SerializedName("team-2")
    String team2;
    @SerializedName("team-1")
    String team1;
    String matchStarted;

    public matches(Integer unique_id, String date, String squad, String team2, String team1, String matchStarted) {
        this.unique_id = unique_id;
        this.date = date;
        this.squad = squad;
        this.team2 = team2;
        this.team1 = team1;
        this.matchStarted = matchStarted;
    }

    public Integer getUnique_id() {
        return unique_id;
    }

    public String getDate() {
        return date;
    }

    public String getSquad() {
        return squad;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTeam1() {
        return team1;
    }

    public String getMatchStarted() {
        return matchStarted;
    }
}
