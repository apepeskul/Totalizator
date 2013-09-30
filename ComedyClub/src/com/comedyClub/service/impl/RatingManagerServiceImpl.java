package com.comedyClub.service.impl;

import com.comedyClub.dao.IRatingDao;
import com.comedyClub.dao.IStoryDao;
import com.comedyClub.dao.IUserDao;
import com.comedyClub.domain.Rating;
import com.comedyClub.domain.Story;
import com.comedyClub.domain.User;
import com.comedyClub.dto.RatingDto;
import com.comedyClub.service.IRatingManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RatingManagerServiceImpl implements IRatingManagerService {
	IRatingDao ratingDao;
	IStoryDao storyDao;
	IUserDao userDao;
	
	public RatingManagerServiceImpl() {
	}

	public void setRatingDao(IRatingDao ratingDao) {
		this.ratingDao = ratingDao;
	}
	
	public void setStoryDao(IStoryDao storyDao) {
		this.storyDao = storyDao;
	}
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	private RatingDto makeDtoFromRating(Rating rating) {
		RatingDto ratingDto = new RatingDto();
		
		ratingDto.setId(rating.getId());
		ratingDto.setRate(rating.getRate());
		ratingDto.setStoryId(rating.getStory().getId());
		ratingDto.setUserId(rating.getUser().getId());
		
		return ratingDto;		
	}
	
	private List<RatingDto> makeDtosFromRatings(List<Rating> ratings) {
		
		List<RatingDto> ratingsDto = new ArrayList<RatingDto>();

        for (Object rating1 : ratings) {
            Rating rating = (Rating) rating1;
            ratingsDto.add(makeDtoFromRating(rating));
        }
		
		return ratingsDto;
	}

	public RatingDto addRating(RatingDto ratingDto) {
		Rating rating = new Rating();	
		Story story = storyDao.getById(ratingDto.getStoryId());
		User user = userDao.getById(ratingDto.getUserId());
		
		rating.setRate(ratingDto.getRate());
		rating.setUser(user);
		story.addRating(rating);
		
		storyDao.update(story);
		
		rating = ratingDao.getByStoryAndUser(ratingDto.getStoryId(), ratingDto.getUserId());
		
		return makeDtoFromRating(rating);
	}

	public void updateRating(RatingDto ratingDto) {
		Rating rating = ratingDao.getById(ratingDto.getId());
		rating.setRate(ratingDto.getRate());
		
		ratingDao.update(rating);
	}

	public void deleteRating(Long ratingId) {
		ratingDao.deleteById(ratingId);
	}

	public RatingDto getRatingByStoryAndUser(Long storyId, Long userId) {
		Rating rating = ratingDao.getByStoryAndUser(storyId, userId);
		return makeDtoFromRating(rating);
	}

	public RatingDto getRatingById(Long ratingId) {
		Rating rating = ratingDao.getById(ratingId);
		return makeDtoFromRating(rating);
	}

	public List<RatingDto> getAllStoryRatings(Long storyId) {
		List<Rating> ratings = ratingDao.getByStory(storyId);
		return makeDtosFromRatings(ratings);
	}

	public List<RatingDto> getAllRatings() {
		List<Rating> ratings = ratingDao.getAllRatings();
		return makeDtosFromRatings(ratings);
	}

}
