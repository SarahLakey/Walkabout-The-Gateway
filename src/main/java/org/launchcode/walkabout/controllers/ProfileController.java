package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    //TODO: Add @Autowired annotation + repositories

        @GetMapping("profile")
        public String displayUserProfile(Model model, HttpSession session) {
            model.addAttribute("loggedIn", session.getAttribute("user") != null);

            return "profile";
        }

    }
