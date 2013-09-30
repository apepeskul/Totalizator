package com.comedyClub.dao.impl;

import com.comedyClub.dao.IStoryDao;
import com.comedyClub.domain.Story;

import java.util.List;

public class StoryDaoImpl extends BaseAbstractDao implements IStoryDao {

    public StoryDaoImpl() {
    }

    public void update(Story story) {
        super.updateEntity(story);
    }

    public Story getById(Long storyId) {
        return (Story) super.getEntityById(Story.class, storyId);
    }

    public Story getByUserAndTitle(Long userId, String title) {
        String queryString = "from Story s where s.user.id = :uid and s.title = :title";
        return (Story) getHibernateTemplate()
                .findByNamedParam(queryString,
                        new String[]{"uid", "title"},
                        new Object[]{userId, title})
                .get(0);
    }

    public void delete(Story story) {
        super.deleteEntity(story);
    }

    public void deleteById(Long storyId) {
        super.deleteEntityById(Story.class, storyId);
    }

    @SuppressWarnings("unchecked")
    public List<Story> getByTitle(String title) {
        return super.findFiltered(Story.class, "title", title);
    }

    @SuppressWarnings("unchecked")
    public List<Story> getByUser(Long userId) {
        String queryString = "from Story s where s.user.id = :uid";
        List stories = getHibernateTemplate().findByNamedParam(queryString, "uid", userId);
        return stories;
    }

    @SuppressWarnings("unchecked")
    public List<Story> getAllStories() {
        return super.findAll(Story.class);
    }
}
