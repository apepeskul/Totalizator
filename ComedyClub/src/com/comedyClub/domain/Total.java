package com.comedyClub.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 30.09.13
 * Time: 4:38
 * To change this template use File | Settings | File Templates.
 */
public class Total {
  private long id;
  private User creator;
  private boolean isPublic;
  private Competition competiotion;
  private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Competition getCompetiotion() {
        return competiotion;
    }

    public void setCompetiotion(Competition competiotion) {
        this.competiotion = competiotion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
