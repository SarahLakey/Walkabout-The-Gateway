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

//            if (request.getAttribute("name") != null) {
//                model.addAttribute("nameInput", request.getAttribute("name"));
//            }
//            if (request.getAttribute("location") != null) {
//                model.addAttribute("locationInput", request.getAttribute("location"));
//            }
//            if (request.getAttribute("fact") != null) {
//                model.addAttribute("factInput", request.getAttribute("fact"));
//            }

            return "admin/index";

    }

    @PostMapping("/submitFact")
    public String processSubmitFact(HttpServletRequest request, Model model, @ModelAttribute SubmitFact submitFact) {
//
//        String nameInput = request.getParameter("name");
//        String locationInput = request.getParameter("location");
//        String factInput = request.getParameter("fact");
//
//        request.setAttribute("name", nameInput);
//        request.setAttribute("location", locationInput);
//        request.setAttribute("fact", factInput);

        model.addAttribute("nameInput", submitFact.getNameInput());
        model.addAttribute("locationInput", submitFact.getLocationInput());
        model.addAttribute("factInput", submitFact.getFactInput());
        return "redirect:/admin";

    }
}