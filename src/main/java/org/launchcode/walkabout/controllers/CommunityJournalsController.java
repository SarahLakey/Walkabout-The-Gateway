package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/communityjournals")
public class CommunityJournalsController {
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private UserJournalController userJournalController;
    @Autowired
    private AuthenticationController authenticationController;
    @GetMapping
    public String ReadJournalsControllerDisplay(HttpServletRequest request, HttpSession session, Model model) {
        String journalLocation = authenticationController.getUserFromSession(session).getUsername();
        //String journalLocation = userJournalController.displayUserJournal(journalLocation);
        List<UserJournal> journalEntries = (List<UserJournal>) journalRepository.findAll();


        model.addAttribute("user", new User());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        model.addAttribute("userjournal", new UserJournal());
        model.addAttribute("journalEntries", journalEntries);
        return "journalentries/communityjournals";}
}
