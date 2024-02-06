package org.launchcode.walkabout.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayMapPageController {

    @GetMapping("map-display")
    public String displayMapController(){
        return "map-display";
    }

}
