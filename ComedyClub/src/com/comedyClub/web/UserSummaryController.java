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

public class UserSummaryController extends AbstractController {

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
	    final Log logger = LogFactory.getLog(getClass());

        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        long targetUserId = Long.parseLong(request.getParameter("user"));
	    
	    UserDto user = (UserDto)request.getSession().getAttribute("user");
	    List<UserDto> friends = userManagerService.getAllFriends(user.getId());
	    
		UserDto targetUser = userManagerService.getUserById(targetUserId);  
		String isFriend = new String();
		
		if (friends.contains(targetUser)) {
			isFriend = "user is in your friends list";
		} else {
			isFriend = "user is not in your friends list";
		}
		
		logger.info("returning summary page of user " + user + " for user " + targetUser);
		
		ModelAndView userSummary = new ModelAndView("userSummary");
		userSummary.addObject("user", targetUser);
		userSummary.addObject("isFriend", isFriend);
		return userSummary;
		
	}	

	private IUserManagerService userManagerService;		

	public void setUserManagerService(IUserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
}
