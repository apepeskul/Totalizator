package com.comedyClub.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.dto.RatingDto;
import com.comedyClub.dto.StoryDto;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IRatingManagerService;
import com.comedyClub.service.IStoryManagerService;

public class RateUserStoryFormController extends SimpleFormController {
    /** Logger for this class and subclasses */
    final Log logger = LogFactory.getLog(getClass());  
 
    public ModelAndView onSubmit(Object command) throws ServletException {

    	RatingDto rating = (RatingDto) command;
    	ratingManagerService.addRating(rating);
    	logger.info("Rating added: " + rating);
    	
    	StoryDto story = storyManagerService.getStoryById(rating.getStoryId());
    	
        return new ModelAndView(new RedirectView(getSuccessView() + "?user=" + story.getUserId()));        
    }
    

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
    	
    	UserDto user = (UserDto)request.getSession().getAttribute("user");
	    long storyId = Long.parseLong(request.getParameter("story"));	    
    	
        RatingDto rating = new RatingDto();
        rating.setStoryId(storyId);
        rating.setUserId(user.getId());        
        return rating;
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (!CheckUserInSession.isUserInSession(httpServletRequest)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }
        
        return super.handleRequestInternal(httpServletRequest, httpServletResponse);    //To change body of overridden methods use File | Settings | File Templates.
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




