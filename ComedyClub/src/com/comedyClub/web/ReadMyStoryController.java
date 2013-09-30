package com.comedyClub.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.dto.StoryDto;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IStoryManagerService;

public class ReadMyStoryController extends AbstractController {
	
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

		ModelAndView readMyStory = new ModelAndView("readMyStory");
		readMyStory.addObject("user", user);
		readMyStory.addObject("story", story);
		logger.info("User " + user + " reading his story " + story);
		return readMyStory;				

		}
	

	private IStoryManagerService storyManagerService;		

	public void setStoryManagerService(IStoryManagerService storyManagerService) {
		this.storyManagerService = storyManagerService;
	}
	
}

