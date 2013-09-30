package com.comedyClub.service.impl;

import com.comedyClub.dao.IStoryDao;
import com.comedyClub.dao.IUserDao;
import com.comedyClub.domain.Story;
import com.comedyClub.domain.User;
import com.comedyClub.dto.StoryDto;
import com.comedyClub.service.IStoryManagerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StoryManagerServiceImpl implements IStoryManagerService {
	IStoryDao storyDao;
	IUserDao userDao;

	public StoryManagerServiceImpl() {
	}

	public void setStoryDao(IStoryDao storyDao) {
		this.storyDao = storyDao;
	}
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	private StoryDto makeDtoFromStory(Story story) {
		StoryDto storyDto = new StoryDto();
		
		storyDto.setId(story.getId());
		storyDto.setTitle(story.getTitle());
		storyDto.setContent(story.getContent());
		storyDto.setIsPublic(story.getIsPublic());
		storyDto.setUserId(story.getUser().getId());
		
		return storyDto;		
	}
	
	private List<StoryDto> makeDtosFromStories(List<Story> stories) {
		
		List<StoryDto> storiesDto = new ArrayList<StoryDto>();

        for (Object story1 : stories) {
            Story story = (Story) story1;
            storiesDto.add(makeDtoFromStory(story));
        }
		
		return storiesDto;
	}

	private void setStoryFromDto(StoryDto storyDto, Story story) {
		story.setTitle(storyDto.getTitle());
		story.setContent(storyDto.getContent());
		story.setIsPublic(storyDto.getIsPublic());
	}

	public StoryDto addStory(StoryDto storyDto) {
		User user = userDao.getById(storyDto.getUserId());
		
		Story story = new Story();
		setStoryFromDto(storyDto, story);
		
		user.addStory(story);
		userDao.update(user);
		
		story = storyDao.getByUserAndTitle(storyDto.getUserId(), storyDto.getTitle());
		
		return makeDtoFromStory(story);  
	}

	public void updateStory(StoryDto storyDto) {
		Story story = storyDao.getById(storyDto.getId()); 
		
		setStoryFromDto(storyDto, story);
		storyDao.update(story);
	}

	public void deleteStory(Long storyId) {
		storyDao.deleteById(storyId);
	}
	
	public StoryDto getStoryByTitleAndUser(String title, Long userId) {
		Story story = storyDao.getByUserAndTitle(userId, title);
		
		return makeDtoFromStory(story);
	}

	public StoryDto getStoryById(Long storyId) {
		Story story = storyDao.getById(storyId);
		
		return makeDtoFromStory(story);
	}

	public List<StoryDto> getAllUserStories(Long userId) {
		User user = userDao.getById(userId);
        List<Story> userStories = new ArrayList<Story>();
        userStories.addAll(user.getStories());
        return makeDtosFromStories(userStories);
	}

	public List<StoryDto> getAllStories() {
		return makeDtosFromStories(storyDao.getAllStories());
	}

}
