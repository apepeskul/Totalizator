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

public class AddFriendController  extends AbstractController {

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/** Logger for this class and subclasses */
	    final Log logger = LogFactory.getLog(getClass());

        if (!CheckUserInSession.isUserInSession(request)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        long friendId = Long.parseLong(request.getParameter("user"));
	    
	    UserDto user = (UserDto)request.getSession().getAttribute("user");
	    List<UserDto> friends = userManagerService.getAllFriends(user.getId());
		UserDto targetUser = userManagerService.getUserById(friendId);
		String message;
		
		if (!friends.contains(targetUser)) {
			userManagerService.addFriend(user.getId(), friendId);
			logger.info("user with " + user + " add to his friends list user " + targetUser);
			message = targetUser.getName() + " was successfully added to your friends list";
		} else {
			message = targetUser.getName() + " is already in your friends list";			
			logger.info("user " + user + " already have in his friends list user " + targetUser);			
		}
		
		ModelAndView addFriend = new ModelAndView("addRemoveFriend");
		addFriend.addObject("user", targetUser);
		addFriend.addObject("message", message);			
		return addFriend;
		
	}

	private IUserManagerService userManagerService;		

	public void setUserManagerService(IUserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
}

