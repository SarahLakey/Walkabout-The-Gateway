package org.launchcode.walkabout.controllers;
import org.launchcode.walkabout.data.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/favorites")
public class UserFavoriteListController {

   // @Autowired
 //   FavoritesRepository favoritesRepository;

    @GetMapping
    public String displayFavorites(Model model){
        model.addAttribute("title", "Your Favorites");
   // model.addAttribute("favorites", favoritesRepository.findAll());
        return "favorite-Lou-Spots/index";
    }

    @GetMapping("/add-a-fave")
    public String addAFavorite(Model model){

        return "favorite-Lou-Spots/add-a-fave";
    }

    @PostMapping("/add-a-fave")
    public String addAFavorite(Model model, Errors errors){

        return "redirect:/favorites";
    }

}
