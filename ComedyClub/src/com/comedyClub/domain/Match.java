package com.comedyClub.domain;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 30.09.13
 * Time: 4:58
 * To change this template use File | Settings | File Templates.
 */
public class Match {
    private long id;
    private Team home_team, away_team;
    private short hteam_score, ateam_score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getHome_team() {
        return home_team;
    }

    public void setHome_team(Team home_team) {
        this.home_team = home_team;
    }

    public Team getAway_team() {
        return away_team;
    }

    public void setAway_team(Team away_team) {
        this.away_team = away_team;
    }

    public short getHteam_score() {
        return hteam_score;
    }

    public void setHteam_score(short hteam_score) {
        this.hteam_score = hteam_score;
    }

    public short getAteam_score() {
        return ateam_score;
    }

    public void setAteam_score(short ateam_score) {
        this.ateam_score = ateam_score;
    }
}
