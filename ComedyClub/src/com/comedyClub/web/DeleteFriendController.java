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

public class DeleteFriendController extends AbstractController {

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
		
		if (friends.contains(targetUser)) {
			userManagerService.deleteFriend(user.getId(), friendId);
			logger.info("user " + user + " remove from his friends list user " + targetUser);
			message = targetUser.getName() + " was succesfully deleted from your friends list";
		} else {
			message = targetUser.getName() + " is not in your friends list";
			logger.info("user " + user + " don't have in his friends list user " + targetUser);
		}
				
		ModelAndView deleteFriend = new ModelAndView("addRemoveFriend");
		deleteFriend.addObject("user", targetUser);
		deleteFriend.addObject("message", message);
		return deleteFriend;
	}

	private IUserManagerService userManagerService;		

	public void setUserManagerService(IUserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
}

