package com.comedyClub.web.validator;

import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IUserManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

public class RegisterUserFormValidator implements Validator {

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
        	List users = userManagerService.getUsersByName(user.getName());
            if (users != null && users.size() > 0) {
                logger.error("user with name: " + user.getName() + " already exist");
                errors.rejectValue("name", "user.exist", null, "Value required.");
            }
        } catch (Exception e) {
        	logger.info("Name: " + user.getName() + " correct");
        }
       
    }
}

