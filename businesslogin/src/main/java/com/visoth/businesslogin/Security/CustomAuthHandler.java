package com.visoth.businesslogin.Security;

import com.visoth.businesslogin.Entity.User;
import com.visoth.businesslogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        User user=userService.findUsername(authentication.getName());
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        response.sendRedirect(request.getContextPath()+"/");
    }
}
