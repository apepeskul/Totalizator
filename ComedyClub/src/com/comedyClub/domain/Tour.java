package com.comedyClub.domain;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 30.09.13
 * Time: 4:57
 * To change this template use File | Settings | File Templates.
 */
public class Tour {
    private long id;
    private Match match;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
