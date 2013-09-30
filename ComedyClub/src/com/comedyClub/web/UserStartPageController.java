package com.comedyClub.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.dto.UserDto;

public class UserStartPageController extends AbstractController {
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
	    final Log logger = LogFactory.getLog(getClass());
        
        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        UserDto user = (UserDto)request.getSession().getAttribute("user");
			
		logger.info("returning starter page for user " + user);

        return new ModelAndView("userStartPage", "user_name", user.getName());
	}
	
}
