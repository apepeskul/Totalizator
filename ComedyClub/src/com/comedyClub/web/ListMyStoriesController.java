package com.comedyClub.web;

import com.comedyClub.dto.StoryDto;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IRatingManagerService;
import com.comedyClub.service.IStoryManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

public class ListMyStoriesController extends AbstractController {

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
	    final Log logger = LogFactory.getLog(getClass());

        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        //long id = Long.parseLong(request.getParameter("id"));
	    UserDto user = (UserDto)request.getSession().getAttribute("user");

		logger.info("getting all stories of user " + user);
		List<StoryDto> userStories = storyManagerService.getAllUserStories(user.getId());
		List<ExtendedStory> extendedUserStories = ExtendedStory.extendedStories(userStories, ratingManagerService);
			
		ModelAndView listMyStories = new ModelAndView("listMyStories");
		listMyStories.addObject("extendedUserStories", extendedUserStories);
		return listMyStories;
	}

	private IStoryManagerService storyManagerService;		

	public void setStoryManagerService(IStoryManagerService storyManagerService) {
		this.storyManagerService = storyManagerService;
	}
	  
    private IRatingManagerService ratingManagerService;

    public void setRatingManagerService(IRatingManagerService ratingManagerService) {
    	this.ratingManagerService = ratingManagerService;
    }
    
}
