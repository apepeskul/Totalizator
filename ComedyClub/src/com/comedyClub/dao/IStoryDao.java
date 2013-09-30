package com.comedyClub.dao;

import com.comedyClub.domain.Story;

import java.util.List;

public interface IStoryDao {
	void update(Story story);
	Story getById(Long storyId);
	Story getByUserAndTitle(Long userId, String title);
	void delete(Story story);
	void deleteById(Long storyId);	
	
	List<Story> getByTitle(String title);
	List<Story> getByUser(Long userId);
	List<Story> getAllStories();
}
