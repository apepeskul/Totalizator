package com.comedyClub.web.validator;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.dto.StoryDto;

public class EditStoryFormValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(StoryDto.class);
    }

    public void validate(Object obj, Errors errors) {
    	StoryDto story = (StoryDto)obj;
    	logger.info("###### validate story: " + story + " id = " + story.getId());
    	ValidationUtils.rejectIfEmpty(errors, "content", "story.empty-content");    	
    }
           
}

