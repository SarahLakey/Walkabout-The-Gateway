package org.launchcode.walkabout.controllers;

import org.launchcode.walkabout.models.ReportButton;
import org.launchcode.walkabout.models.SubmitFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String submitFactForm(Model model) {
        model.addAttribute("submitFact", new SubmitFact());
        return "submitFact";
    }

    @PostMapping("/admin")
    public String submitFactForm(@ModelAttribute SubmitFact submitFact, Model model) {
        model.addAttribute("submitFact", submitFact);
        return "result";
    }

    @GetMapping("/adminTwo")
    public String submitReportForm(Model model){
        model.addAttribute("reportButton", new ReportButton());
        return "submitReport";
    }

    @PostMapping("/adminTwo")
    public String submitReportForm(@ModelAttribute ReportButton reportButton, Model model) {
        model.addAttribute("reportButton", reportButton);
        return "result";
    }

}
