package src.main.java.org.launchcode.walkabout.controllers;
import jdk.jfr.Event;
import org.springframework.web.bind.annotation.GetMapping;
import src.main.java.org.launchcode.walkabout.models.dto.ReportButtonDTO;

public class ButtonController {

    @GetMapping("ReportButtonDTO") //events/add-tag.html
    public String displayAddTagForm (@RequestParam Event event, Model model)
    Event event = result.get();
    model.addAttribute("title", "Report Here: " + event.getName());
    model.addAttribute("tags", tagRepository.findAll());
    ReportButtonDTO eventTag = new ReportButtonDTO();
    eventTag.setEvent(event);
    model.addAttribute("eventTag", eventTag);
    //return "events/add-tag.html";
}
