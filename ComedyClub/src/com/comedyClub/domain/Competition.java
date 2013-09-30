package com.comedyClub.domain;

import sun.net.www.protocol.mailto.MailToURLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 30.09.13
 * Time: 4:55
 * To change this template use File | Settings | File Templates.
 */
public class Competition {
    private long id;
    private String title;
    private Tour tour;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
