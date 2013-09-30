package com.comedyClub.web;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IUserManagerService;

public class RegisterUserFormController extends SimpleFormController {
    /** Logger for this class and subclasses */
    final Log logger = LogFactory.getLog(getClass());
    
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException e) throws ServletException {
    	UserDto user = userManagerService.registerNewUser((UserDto) command);
   	
		logger.info("user with name = " + user.getName() + " successfully added");
		
       	request.getSession().setAttribute("user", user);
        return new ModelAndView(new RedirectView(getSuccessView()));        
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        UserDto user = new UserDto();
        return user;
    }

    private IUserManagerService userManagerService;
    
    public void setUserManagerService(IUserManagerService userManagerService) {
    	this.userManagerService = userManagerService;
    }

}



