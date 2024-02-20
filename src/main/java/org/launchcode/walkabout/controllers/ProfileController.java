package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfileController {

    //TODO: Add @Autowired annotation + repositories

@Autowired
   private UserRepository userRepository;

@Autowired
private AuthenticationController authenticationController;

private User getCurrentUser(HttpServletRequest request) {
    HttpSession session = request.getSession();
    return authenticationController.getUserFromSession(session);
}


        @GetMapping
    public String displayProfilePage(HttpServletRequest request, HttpSession session, Model model) {
        User user = getCurrentUser(request);

        model.addAttribute("user", userRepository.findById(user.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);


            return "profile/index";
        }

        @GetMapping ("/admin")
    public String style(){
            return "admin";
        }


    }
