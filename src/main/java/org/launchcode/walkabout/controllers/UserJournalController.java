package org.launchcode.walkabout.controllers;

import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("userjournal")
public class UserJournalController{

    private static List<UserJournal> userJournals = new ArrayList<>();

    @GetMapping
    public String newJournalController()

    {return "userjournal/journalentries";}

    @GetMapping
    public String processCreateEventForm(Model model) {
        model.addAttribute("title", "All Journals");
        model.addAttribute("userJournals", userJournals);
        return "userJournals/create:";
    }


    /*@Autowired
    private JournalRepository journalRepository;

    @PostMapping(path="/add")
    public @ResponseBody String createNewJournal(@RequestParam String journalEntry, @RequestParam String journalLocation, @RequestParam String journalDate){
    UserJournal n = new UserJournal();
    n.setJournalEntry(journalEntry);
    n.setJournalLocation(journalLocation);
    n.setJournalDate(journalDate);
    journalRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserJournal> getAllUserJournals() {
        return journalRepository.findAll();
    } */

    /*@RequestMapping(value = "/userjournal", method = RequestMethod.POST)
    public String userJournalSubmit(@ModelAttribute UserJournal userJournal, Model model){
        model.addAttribute("userjournal", userJournal);
        return "result";
    }*/

}