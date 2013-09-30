package com.comedyClub.web;

import com.comedyClub.dto.RatingDto;
import com.comedyClub.dto.StoryDto;
import com.comedyClub.service.IRatingManagerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExtendedStory {
	StoryDto story;
		
	double averageRating = 0.0;
	
	IRatingManagerService ratingManagerService;
	
	public void setRatingManagerService(IRatingManagerService ratingManagerService) {
		this.ratingManagerService = ratingManagerService;
	}
	
	public ExtendedStory() {
	}
	
	public StoryDto getStory() {
		return story;
	}

	public void setStory(StoryDto story) {
		this.story = story;
		
		List<RatingDto> ratings = ratingManagerService.getAllStoryRatings(story.getId());
		
		double averageRating = 0;
		int count = 0;

        Iterator<RatingDto> i;
        for (i = ratings.iterator(); i.hasNext(); count++) {
			averageRating += i.next().getRate();
		}
		
		if (count != 0) {
			averageRating /= count;
		}
		
		this.averageRating = averageRating;
	}
	
	public double getAverageRating() {
		return averageRating;
	}
	

	public static List<ExtendedStory> extendedStories(List<StoryDto> stories, IRatingManagerService ratingManagerService) {
		List<ExtendedStory> extendedStories = new ArrayList<ExtendedStory>();

        for (StoryDto story1 : stories) {
            ExtendedStory extendedStory = new ExtendedStory();
            extendedStory.setRatingManagerService(ratingManagerService);
            extendedStory.setStory(story1);
            extendedStories.add(extendedStory);
        }
		
		return extendedStories;
	}
}
