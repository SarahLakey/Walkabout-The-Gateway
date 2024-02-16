package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.SubmitFact;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);
    }


    @GetMapping("/admin")
    public String submitFactForm(HttpServletRequest request, HttpSession session, Model model) {
        User user = getCurrentUser(request);

            model.addAttribute("user", userRepository.findById(user.getId()));
            model.addAttribute("loggedIn", session.getAttribute("user") != null);
            model.addAttribute("submitFact", new SubmitFact());

            return "admin/index";

    }

    @PostMapping("/admin")
    public String processSubmitFact(HttpServletRequest request, Model model, @ModelAttribute SubmitFact submitFact) {
        model.addAttribute("nameInput", submitFact.getNameInput());
        model.addAttribute("locationInput", submitFact.getLocationInput());
        model.addAttribute("factInput", submitFact.getFactInput());
        model.addAttribute("submitFact", submitFact);

        return "admin/index";
    }
}