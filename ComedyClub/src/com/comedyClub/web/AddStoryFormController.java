package com.comedyClub.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.dto.StoryDto;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IStoryManagerService;

public class AddStoryFormController extends SimpleFormController {
    /** Logger for this class and subclasses */
    final Log logger = LogFactory.getLog(getClass());  

    public ModelAndView onSubmit(Object command) throws ServletException {

    	StoryDto story = (StoryDto) command;
    	storyManagerService.addStory(story);
    	
    	logger.info("added new story: " + story);
    	   	
        return new ModelAndView(new RedirectView(getSuccessView()));        
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (!CheckUserInSession.isUserInSession(httpServletRequest)) {
            logger.error("Unauthorized access!");
            return new ModelAndView("userLogin", "userToLogin", new UserDto());
        }

        return super.handleRequestInternal(httpServletRequest, httpServletResponse);    //To change body of overridden methods use File | Settings | File Templates.
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
    	
    	UserDto user = (UserDto)request.getSession().getAttribute("user");
    	
        StoryDto story = new StoryDto();
        story.setUserId(user.getId());      
        story.setIsPublic(false);
        return story;
    }
    
    
    
    protected Map referenceData(HttpServletRequest request) throws Exception {
    	Map<String, List> res = new HashMap<String, List> ();
    	List<Boolean> trueFalse = new ArrayList<Boolean> ();
    	trueFalse.add(new Boolean(true));
    	trueFalse.add(new Boolean(false));    	
    	
    	res.put("trueFalse", trueFalse);
    	return res;
    }
    
	private IStoryManagerService storyManagerService;		

	public void setStoryManagerService(IStoryManagerService storyManagerService) {
		this.storyManagerService = storyManagerService;
	}	
}




