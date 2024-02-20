package org.launchcode.walkabout.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/editjournals")
public class EditJournalController {

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private AuthenticationController authenticationController;
    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);

    }
    @GetMapping
    public String displayEditController(HttpServletRequest request, HttpSession session, Model model){
        List<UserJournal> journalEntries = (List<UserJournal>) journalRepository.findAll();

        model.addAttribute("user", new User());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        model.addAttribute("userjournal", new UserJournal());
        model.addAttribute("journalEntries", journalEntries);
        /*String edit = userJournal.getJournalEntryBlank();
        journalRepository.save(edit);*/
        return "journalentries/editjournals";
    }

    @PostMapping("/edit")
    public String processEditController(@Valid UserJournal userJournal, Errors errors, Model model, HttpSession session, HttpServletRequest request) {
        UserJournal journalEntry = new UserJournal(getCurrentUser(request).getUsername(), userJournal.getJournalEntryBlank(), userJournal.getJournalLocation(), userJournal.getJournalDate(), userJournal.getComments());
        //UserJournal journalEntry = new UserJournal();
        //journalEntry.setJournalEntryBlank(userJournal.getJournalEntryBlank() + userJournal.getJournalEntryBlank());
        journalRepository.save(journalEntry);
        return "redirect:/readjournals";
    }
}
