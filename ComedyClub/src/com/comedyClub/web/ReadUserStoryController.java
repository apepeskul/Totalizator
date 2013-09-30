package com.comedyClub.web;

import com.comedyClub.dto.StoryDto;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IStoryManagerService;
import com.comedyClub.service.IUserManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReadUserStoryController extends AbstractController {
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
	    final Log logger = LogFactory.getLog(getClass());

        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        long storyId = Long.parseLong(request.getParameter("story"));

		UserDto user = (UserDto)request.getSession().getAttribute("user");
		StoryDto story = storyManagerService.getStoryById(storyId);
		UserDto storyAuthor = userManagerService.getUserById(story.getUserId());
		List<UserDto> authorFriends = userManagerService.getAllFriends(storyAuthor.getId());
		
		if ((!story.getIsPublic() && authorFriends.contains(user)) || story.getIsPublic()) {
			ModelAndView readUserStory = new ModelAndView("readUserStory");
			readUserStory.addObject("user", storyAuthor);
			readUserStory.addObject("story", story);
			logger.info("User " + user + " allowed to read story with " + story);
			return readUserStory;				
		} else {
			logger.info("Acess denied to read story " + story + " by user " + user);
			ModelAndView readUserStoryDenied = new ModelAndView("readUserStoryDenied");
			readUserStoryDenied.addObject("user", storyAuthor);
			return readUserStoryDenied;
		}
	}
	

	private IStoryManagerService storyManagerService;		

	public void setStoryManagerService(IStoryManagerService storyManagerService) {
		this.storyManagerService = storyManagerService;
	}
	
    private IUserManagerService userManagerService;

    public void setUserManagerService(IUserManagerService userManagerService) {
    	this.userManagerService = userManagerService;
    }
}
