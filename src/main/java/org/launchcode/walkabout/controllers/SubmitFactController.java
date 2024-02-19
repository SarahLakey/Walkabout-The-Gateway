package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;
import org.launchcode.walkabout.data.SubmitFactRepository;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.SubmitFact;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class SubmitFactController {

    @NotNull
    private String nameInput;

    @NotNull
    private String locationInput;

    @NotNull
    private String factInput;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private SubmitFactRepository submitFactRepository;

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);
    }

    @GetMapping
    public String submitFactForm(HttpServletRequest request, HttpSession session, Model model) {

        List<SubmitFact> submitFacts = (List<SubmitFact>) submitFactRepository.findAll();

        model.addAttribute("user", new User());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        model.addAttribute("submitFact", new SubmitFact());
        model.addAttribute("submitFacts", submitFacts);

        return "admin/index";

    }

    @PostMapping("/admin")
    public String processSubmitFact(HttpServletRequest request, Model model, @ModelAttribute SubmitFact submitFact) {

    SubmitFact submitFact1 = new SubmitFact(getCurrentUser(request).getUsername(), submitFact.getNameInput(),
            submitFact.getLocationInput(), submitFact.getFactInput());


        model.addAttribute("nameInput", submitFact.getNameInput());
        model.addAttribute("locationInput", submitFact.getLocationInput());
        model.addAttribute("factInput", submitFact.getFactInput());
        model.addAttribute("submitFact", submitFact);

        submitFactRepository.save(submitFact);

        return "admin/index";
    }
}
