package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log-a-trip")
public class LogATripController {
    @GetMapping
    public String displayLogATripForm() {



        return "log-a-trip/index";
    }
}
