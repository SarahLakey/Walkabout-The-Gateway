package org.launchcode.walkabout;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.controllers.AuthenticationController;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    AuthenticationController authenticationController;


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

    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.anyRequest().authenticated();
                })

                .formLogin(form->form.loginPage("/login").permitAll())
//                .formLogin(withDefaults())
                .oauth2Login(withDefaults())
                .build();
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
