package com.comedyClub.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.service.IStoryManagerService;
import com.comedyClub.dto.UserDto;

public class DeleteStoryController   extends AbstractController {

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
	    final Log logger = LogFactory.getLog(getClass());

        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        long storyId = Long.parseLong(request.getParameter("story"));
	    
		storyManagerService.deleteStory(storyId);
		
		ModelAndView deleteStory = new ModelAndView("deleteStory");
		logger.info("Story with id = " + storyId + " wsa deleted");
		return deleteStory;
		
	}

	private IStoryManagerService storyManagerService;		

	public void setStoryManagerService(IStoryManagerService storyManagerService) {
		this.storyManagerService =  storyManagerService;
	}
}

