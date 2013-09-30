package com.comedyClub.web.validator;

import com.comedyClub.dto.RatingDto;
import com.comedyClub.dto.StoryDto;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IRatingManagerService;
import com.comedyClub.service.IStoryManagerService;
import com.comedyClub.service.IUserManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RateUserStoryFormValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    final int MIN_RATING = 1;
    final int MAX_RATING = 5;
    
    private int minRating = MIN_RATING;
    private int maxRating = MAX_RATING;
    
    public void setMinRating(int minRating) {
    	this.minRating = minRating;
    }
    
    public void setMaxRating(int maxRating) {
    	this.maxRating = maxRating;
    }
    

    public boolean supports(Class clazz) {
        return clazz.equals(RatingDto.class);
    }

    public void validate(Object obj, Errors errors) {
    	try {
    		// check if rating is empty
	    	ValidationUtils.rejectIfEmpty(errors, "rate", "rating.empty");
	    	
	        RatingDto rating = (RatingDto) obj;

	        //Check if user try to rate private story with no access to it
	    	StoryDto story = storyManagerService.getStoryById(rating.getStoryId());
	    	UserDto user = userManagerService.getUserById(rating.getUserId());
	    	List<UserDto> authorFriends = userManagerService.getAllFriends(story.getUserId());
	    	if (!(story.getIsPublic()) && !(authorFriends.contains(user))) {
	        	errors.rejectValue("rate", "rating.private");
	    	}
	    	
	        //Check if user try to rate story twice	    	
	    	List<RatingDto> ratings = ratingManagerService.getAllStoryRatings(rating.getStoryId());
	    	boolean alreadyRated = false;

            for (RatingDto rating1 : ratings) {
                if (rating1.getUserId().equals(rating.getUserId())) {
                    alreadyRated = true;
                    break;
                }
            }
	    	
	    	if (alreadyRated) {
	        	errors.rejectValue("rate", "rating.already-rated");    		
	    	}
	    	
	        //Check if rating value less than minimal
	        if (rating.getRate() < this.minRating) {
//	        	errors.rejectValue("rate", "error.too-low", new Object[] {new Integer(minRating)}, "Value too low.");
	        	errors.rejectValue("rate", "error.too-low", "Value too low.");	        	
	        }
	        
	        //Check if rating value more than maximal	        
	    	if (rating.getRate() > this.maxRating) {
	        	errors.rejectValue("rate", "error.too-high", new Object[] {maxRating}, "Value too high.");	    		
	        }    
	    	
    	} catch (Exception e) {
    		logger.error(e.getMessage());
    	}
    }
    
    IRatingManagerService ratingManagerService;
    
    public void setRatingManagerService(IRatingManagerService ratingManagerService) {
    	this.ratingManagerService = ratingManagerService;
    }
    
    IStoryManagerService storyManagerService;
    
    public void setStoryManagerService(IStoryManagerService storyManagerService) {
    	this.storyManagerService = storyManagerService;
    }
    
    IUserManagerService userManagerService;
    
    public void setUserManagerService(IUserManagerService userManagerService) {
    	this.userManagerService = userManagerService;
    }
    
}

