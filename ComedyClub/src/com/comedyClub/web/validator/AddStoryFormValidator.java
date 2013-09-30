package com.comedyClub.web.validator;

import com.comedyClub.dto.StoryDto;
import com.comedyClub.service.IStoryManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Iterator;
import java.util.List;

public class AddStoryFormValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(StoryDto.class);
    }

    public void validate(Object obj, Errors errors) {
    	ValidationUtils.rejectIfEmpty(errors, "title", "story.empty-title");
    	ValidationUtils.rejectIfEmpty(errors, "content", "story.empty-content");    	
    	
        StoryDto story = (StoryDto) obj;
        
       	List<StoryDto> stories = storyManagerService.getAllUserStories(story.getUserId());
       	 	
    	boolean storyExist = false;
    	for (Iterator<StoryDto> i = stories.iterator(); i.hasNext(); ) {
    		if (i.next().getTitle().equals(story.getTitle())) {
    			storyExist = true;
    			break;
    		}
    	}
    	
    	if (storyExist) {
        	errors.rejectValue("title", "story.already-exist");    		
    	}
    }
    
    IStoryManagerService storyManagerService;
    
    public void setStoryManagerService(IStoryManagerService storyManagerService) {
    	this.storyManagerService = storyManagerService;
    }
       
}