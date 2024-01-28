package org.launchcode.walkabout.controllers;

import jdk.jfr.Event;
import org.launchcode.walkabout.models.dto.ReportButtonDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;

/* public class ButtonController {

    public String displayAddTagForm(@RequestParam Event event, Model model) {
        Event button = result.get();
        model.addAttribute("msg", "Report Here: " + button.getName());
        model.addAttribute("tags", tagRepository.findAll());
        JButton newButton = null;
        ReportButtonDTO eventTag = new ReportButtonDTO(newButton);
        eventTag.setEvent(event);
        model.addAttribute("eventTag");
        return button;
}} */
