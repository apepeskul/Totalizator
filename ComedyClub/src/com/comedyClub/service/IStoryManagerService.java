package com.comedyClub.service;

import com.comedyClub.dto.StoryDto;

import java.util.List;

public interface IStoryManagerService {
	StoryDto addStory(StoryDto storyDto);
	void updateStory(StoryDto storyDto);
	void deleteStory(Long storyId);
	StoryDto getStoryByTitleAndUser(String title, Long userId);
	StoryDto getStoryById(Long storyId);
	
	List<StoryDto> getAllUserStories(Long userId);
	List<StoryDto> getAllStories();
}
