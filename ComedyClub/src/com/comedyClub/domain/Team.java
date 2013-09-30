package com.comedyClub.domain;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 30.09.13
 * Time: 5:00
 * To change this template use File | Settings | File Templates.
 */
public class Team {
    private long id;
    private String team, city;
    private int points;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
