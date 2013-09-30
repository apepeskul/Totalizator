package com.comedyClub.web;

import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IUserManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListUsersController extends AbstractController {
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
		final Log logger = LogFactory.getLog(getClass());

        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        UserDto user = (UserDto)request.getSession().getAttribute("user");

		List<UserDto> users = userManagerService.getAllUsers();
		users.remove(user);
	
		logger.info("Return all users for user " + user);

		ModelAndView listUsers = new ModelAndView("listUsers");
		listUsers.addObject("users", users);
		return listUsers;
	}
	

	private IUserManagerService userManagerService;

	public void setUserManagerService(IUserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
}
