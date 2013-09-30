package com.comedyClub.web;

import com.comedyClub.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CheckUserInSession {
    public static boolean isUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDto user = (UserDto)session.getAttribute("user");

        return user != null;
    }
}
