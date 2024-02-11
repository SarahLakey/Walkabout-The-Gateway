package org.launchcode.walkabout.controllers;

import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserJournalController{

    @RequestMapping(value = "/userjournal", method = RequestMethod.GET)
    public String userJournalForm(Model model){
      model.addAttribute("userjournal", new UserJournal());
    return "journalentries/userjournal";
    }

    @RequestMapping(value = "/userjournal", method = RequestMethod.POST)
    public String userJournalSubmit(@ModelAttribute UserJournal userJournal, Model model){
        model.addAttribute("userjournal", userJournal);
        return "result";
    }

}