package com.comedyClub.service;

import com.comedyClub.dto.RatingDto;

import java.util.List;

public interface IRatingManagerService {
	RatingDto addRating(RatingDto ratingDto);
	void updateRating(RatingDto ratingDto);
	void deleteRating(Long ratingId);
	RatingDto getRatingByStoryAndUser(Long storyId, Long userId);
	RatingDto getRatingById(Long ratingId);	
	
	List<RatingDto> getAllStoryRatings(Long storyId);
	List<RatingDto> getAllRatings();
}
