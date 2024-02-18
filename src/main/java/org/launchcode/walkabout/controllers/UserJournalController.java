package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import jakarta.validation.constraints.NotNull;
import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userjournal")
public class UserJournalController {
    @NotNull
    private String journalEntryBlank;

    @NotNull
    private String journalLocation;

    @NotNull
    private String journalDate;

    @NotNull
    private String userName;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private JournalRepository journalRepository;

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);

    }

    @GetMapping
    public String displayUserJournal(HttpServletRequest request, HttpSession session, Model model) {
        List<UserJournal> journalEntries = (List<UserJournal>) journalRepository.findAll();

        model.addAttribute("user", new User());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        model.addAttribute("userjournal", new UserJournal());
        model.addAttribute("journalEntries", journalEntries);

        return "journalentries/userjournal";
    }


    @PostMapping("/journalsubmission")
    public String processUserJournal(@Valid UserJournal userJournal, Errors errors, Model model, HttpSession session, HttpServletRequest request) {
        UserJournal journalEntry = new UserJournal(getCurrentUser(request).getUsername(), userJournal.getJournalEntryBlank(), userJournal.getJournalLocation(), userJournal.getJournalDate());
        //UserJournal journalEntry = new UserJournal();
        //journalEntry.setJournalEntryBlank(userJournal.getJournalEntryBlank() + userJournal.getJournalEntryBlank());
        journalRepository.save(journalEntry);
        return "redirect:/readjournals";
    }}
