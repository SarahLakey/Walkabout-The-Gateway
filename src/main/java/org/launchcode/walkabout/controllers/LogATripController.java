package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log-a-trip")
public class LogATripController {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private UserRepository userRepository;

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);

    }

    @GetMapping
    public String displayLogATrip(HttpServletRequest request, HttpSession session, Model model) {
        User currentUser = getCurrentUser(request);

        model.addAttribute("user", userRepository.findById(currentUser.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        return "log-a-trip/index";
    }


    @PostMapping("/log")
    public String processLogATrip(@Valid User user, Errors errors, Model model, HttpSession session, HttpServletRequest request) {
        User currentUser = getCurrentUser(request);

        model.addAttribute("user", userRepository.findById(currentUser.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        currentUser.setPoints(user.getPoints() + currentUser.getPoints());

       userRepository.save(currentUser);

        return "profile/index";
    }

//    @PostMapping
//    public String processLogATrip(@Valid User user, Errors errors, Model model, HttpServletRequest request) {
//        User currentUser = getCurrentUser(request);
//
//        if(errors.hasErrors()) {
//
//            return "log-a-trip/index";
//        }
//
//        currentUser.setPoints(user.getPoints() + currentUser.getPoints());
//
//        userRepository.save(currentUser);
//
//        return "redirect:/profile/index";
//
//    }

}
