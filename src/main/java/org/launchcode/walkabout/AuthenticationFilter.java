package org.launchcode.walkabout;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.controllers.AuthenticationController;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    private UserRepository userRepository;


    private static final List<String> whitelist = Arrays.asList("/register", "/login",
            "/styles.css", "/images", "/index");

    private static boolean isWhiteListed(String path) {
        for (String pathRoot : whitelist) {
            if (path.equals("/") || path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {

        if (isWhiteListed(request.getRequestURI())){
            return true;
        }
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        if (user != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}
