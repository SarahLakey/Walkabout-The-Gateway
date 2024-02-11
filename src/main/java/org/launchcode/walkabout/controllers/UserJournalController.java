package org.launchcode.walkabout.controllers;

import org.launchcode.walkabout.data.JournalRepository;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userjournal")
public class UserJournalController{

    @GetMapping
    public String userJournalController()

    {return "journalentries/userjournal";}
}