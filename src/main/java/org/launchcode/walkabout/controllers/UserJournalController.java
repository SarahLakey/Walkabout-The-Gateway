package org.launchcode.walkabout.controllers;

import org.launchcode.walkabout.models.MyUserJournals;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userjournal")
public class UserJournalController{

    private UserJournalController userJournalController;

    /*@GetMapping
    public String displayUserJournals(Model model){
        model.addAttribute("title", "All Journals");
        model.addAttribute("userjournal", UserJournals.getAll());
        return "journalentries/userjournal";
    }

    @GetMapping*/


}