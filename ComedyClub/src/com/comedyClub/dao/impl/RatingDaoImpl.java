package com.comedyClub.dao.impl;

import com.comedyClub.dao.IRatingDao;
import com.comedyClub.domain.Rating;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RatingDaoImpl extends BaseAbstractDao implements IRatingDao {

    public RatingDaoImpl() {
    }

    public void update(Rating rating) {
        super.updateEntity(rating);
    }

    public Rating getById(Long ratingId) {
        return (Rating) super.getEntityById(Rating.class, ratingId);
    }

    public Rating getByStoryAndUser(Long storyId, Long userId) {
        String queryString = "from Rating r where r.story.id = :sid and r.user.id = :uid";
        return (Rating) getHibernateTemplate()
                .findByNamedParam(queryString,
                        new String[]{"sid", "uid"},
                        new Object[]{storyId, userId})
                .get(0);
    }

    public void delete(Rating rating) {
        super.deleteEntity(rating);
    }

    public void deleteById(Long ratingId) {
        super.deleteEntityById(Rating.class, ratingId);
    }

    @SuppressWarnings("unchecked")
    public List<Rating> getByStory(Long storyId) {
        String queryString = "from Rating r where r.story.id = :sid";
        List ratings = getHibernateTemplate().findByNamedParam(queryString, "sid", storyId);
        return ratings;
    }

    @SuppressWarnings("unchecked")
    public List<Rating> getAllRatings() {
        String queryString = "from Rating";
        List ratings = getHibernateTemplate().findByNamedQuery(queryString);
        return ratings;
    }


}
