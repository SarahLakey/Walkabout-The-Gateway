package org.launchcode.walkabout.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.annotations.Array;
import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/readjournals")
public class ReadJournalsController {

    @Autowired
    private JournalRepository journalRepository;
    @GetMapping
    public String ReadJournalsControllerDisplay(HttpServletRequest request, HttpSession session, Model model) {
        List<UserJournal> journalEntries = (List<UserJournal>) journalRepository.findAll();

        model.addAttribute("user", new User());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        model.addAttribute("userjournal", new UserJournal());
        model.addAttribute("journalEntries", journalEntries);
        return "journalentries/readjournals";}

    /*ArrayList<UserJournal> journalE = new ArrayList<>() {
        for (int )
    };*/


}


