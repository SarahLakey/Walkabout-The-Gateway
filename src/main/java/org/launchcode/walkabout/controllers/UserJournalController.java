package org.launchcode.walkabout.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userjournal")
public class UserJournalController{

    @GetMapping
    public String userJournalController()

    {return "journalentries/userjournal";}
}