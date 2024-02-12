package org.launchcode.walkabout.controllers;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.walkabout.data.FavoritesRepository;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.Favorite;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/favorites")
public class UserFavoriteListController {

   // @Autowired
   FavoritesRepository favoritesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);
    }

    @GetMapping
    public String displayFavorites(Model model){
        model.addAttribute("title", "Your Favorites");
   // model.addAttribute("favorites", favoritesRepository.findAll());
        return "favorite-Lou-Spots/index";
    }

    @GetMapping("/add-a-fave")
    public String addAFavorite(Model model){
        model.addAttribute("title", "Add a Favorite");
        model.addAttribute(new Favorite());
        return "favorite-Lou-Spots/add-a-fave";
    }

    @PostMapping("/add-a-fave")
    public String addAFavorite(@ModelAttribute @Valid Favorite newFavorite, Model model, Errors errors){

    if(errors.hasErrors()){
        model.addAttribute("title", "Add a Favorite");
        return "/add-a-fave";
    }

        favoritesRepository.save(newFavorite);
        return "redirect:/favorites";
    }

}
