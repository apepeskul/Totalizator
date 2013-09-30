package com.comedyClub.dao;

import com.comedyClub.domain.Rating;

import java.util.List;

public interface IRatingDao {
	void update(Rating rating);
	Rating getById(Long ratingId);
	Rating getByStoryAndUser(Long storyId, Long userId);	
	void delete(Rating rating);
	void deleteById(Long ratingId);
	
	List<Rating> getByStory(Long storyId);
	List<Rating> getAllRatings();
}
