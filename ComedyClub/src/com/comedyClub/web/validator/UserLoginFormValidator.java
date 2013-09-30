package com.comedyClub.web.validator;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IUserManagerService;

public class UserLoginFormValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private IUserManagerService userManagerService;
    
    public void setUserManagerService(IUserManagerService userManagerService) {
    	this.userManagerService = userManagerService;
    }

    public boolean supports(Class clazz) {
        return clazz.equals(UserDto.class);
    }

    public void validate(Object obj, Errors errors) {
    	ValidationUtils.rejectIfEmpty(errors, "name", "user.empty");
    	ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");

        UserDto user = (UserDto) obj;
        
        try {
        	/*UserDto userDto = */
        	userManagerService.getUserByNameAndPassword(user.getName(), user.getPassword()); 
        } catch (Exception e) {
        	logger.error("user with name: " + user.getName() + " and password: " + user.getPassword() + " not found");
//        	errors.rejectValue("name", "user.not-found", null, "Value required.");
        	errors.rejectValue("name", "user.not-found");
        }
       
    }
}

