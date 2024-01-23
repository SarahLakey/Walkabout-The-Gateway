package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayMapPageController {

    @GetMapping("display-map")
    public String displayMapController(){
        return "map-display";
    }

}
