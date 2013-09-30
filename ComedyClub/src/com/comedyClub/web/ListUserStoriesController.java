package com.comedyClub.web;

import com.comedyClub.dto.StoryDto;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IRatingManagerService;
import com.comedyClub.service.IStoryManagerService;
import com.comedyClub.service.IUserManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

public class ListUserStoriesController extends AbstractController {

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
	    final Log logger = LogFactory.getLog(getClass());

        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        long targetUserId = Long.parseLong(request.getParameter("user"));

	    UserDto targetUser = userManagerService.getUserById(targetUserId);
		logger.info("getting all stories of user " + targetUser);
		
		List<StoryDto> userStories = storyManagerService.getAllUserStories(targetUserId);
		List<ExtendedStory> extendedUserStories = ExtendedStory.extendedStories(userStories, ratingManagerService);
			
		ModelAndView listUserStories = new ModelAndView("listUserStories");	
		listUserStories.addObject("user", targetUser);
		listUserStories.addObject("extendedUserStories", extendedUserStories);
		return listUserStories;
	}

	private IStoryManagerService storyManagerService;		

	public void setStoryManagerService(IStoryManagerService storyManagerService) {
		this.storyManagerService = storyManagerService;
	}
	
    private IUserManagerService userManagerService;

    public void setUserManagerService(IUserManagerService userManagerService) {
    	this.userManagerService = userManagerService;
    }
    
    private IRatingManagerService ratingManagerService;

    public void setRatingManagerService(IRatingManagerService ratingManagerService) {
    	this.ratingManagerService = ratingManagerService;
    }
    
}
