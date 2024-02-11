package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("userjournal")
public class UserJournalController{

    @GetMapping
    public String userJournalController()

    {return "journalentries/userjournal";}
}

   /*public UserJournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @Autowired
    private final JournalRepository journalRepository;

   private UserJournal getJournalEntry(HttpServletRequest request) {
       HttpSession session = request.getSession();
       return journalRepository.getAttribute(UserJournal);
   } */


    /*@RequestMapping(value = "journalTemp", method = RequestMethod.GET)
    public String journalTemps(Model model) {
        model.addAttribute("journalTemps", JournalRepository.findall());
        return "journalTemp/list";
    }

    @RequestMapping(value = "journalTemp", method = RequestMethod.GET)
    public ModelAndView journaltemps() {
        ModelAndView mav = new ModelAndView("journalTemp/list");
        mav.addObject("journalTemps", JournalRepository.findall());
        return mav;
    }

    @ModelAttribute("journalTemps")
    public Object journalTemps() {
        return JournalRepository.findall();
    }

    /*@GetMapping("/userjournal")
    public List<UserJournal> getJournalEntry() {
        return (List<UserJournal>) journalRepository.findAll();
    }

    @PostMapping("/userjournal")
    void addJournal (@RequestBody UserJournal userJournal) {
        journalRepository.save(userJournal);
    }

   /* @GetMapping
    public String displayAllEventForm(Model model) {
        model.addAttribute("title", "All Journals");
        model.addAttribute("userJournals", userJournalsEvents);
        return "userjournal/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title","Create Journal");
        return "userjournal/create";
    }

   @PostMapping("create")
    public String processCreateEventForm(@RequestParam String journalEntry){
        userJournalsEvents.add(new UserJournal());
        return "redirect";
    }*/



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

