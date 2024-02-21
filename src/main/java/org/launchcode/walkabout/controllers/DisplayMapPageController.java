package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.Favorite;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayMapPageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);
    }

    @GetMapping("map-display")
    public String displayMapController(HttpServletRequest request, HttpSession session, Model model){
        User user = getCurrentUser(request);
        Favorite favorites = user.getFavorites();
        model.addAttribute("user", userRepository.findById(user.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        return "map-display";
    }

}
