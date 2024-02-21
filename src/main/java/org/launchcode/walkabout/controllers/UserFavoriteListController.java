package org.launchcode.walkabout.controllers;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.walkabout.data.FavoriteTagRepository;
import org.launchcode.walkabout.data.FavoritesRepository;
import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.Favorite;
import org.launchcode.walkabout.models.FavoriteTag;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("favorites")
public class UserFavoriteListController {

     @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
   private FavoriteTagRepository favoriteTagRepository;



    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);
    }

    @GetMapping
    public String displayFavorites(@RequestParam(required=false) Integer tagFavoriteId, Model model, HttpServletRequest request, HttpSession session){
        User user = getCurrentUser(request);

        model.addAttribute("user", userRepository.findById(user.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        if (tagFavoriteId == null) {
            model.addAttribute("title", "All");
            model.addAttribute("favorites", favoritesRepository.findAll());
            model.addAttribute("favoriteTags", favoriteTagRepository.findAll());
        } else {
            Optional<FavoriteTag> result = favoriteTagRepository.findById(tagFavoriteId);
            FavoriteTag favoriteTag = result.get();
            model.addAttribute("title", "Places marked " + favoriteTag.getDisplayName());
            model.addAttribute("favoriteTags", favoriteTag);
        }

        return "favorite-Lou-Spots/index";
    }

    @GetMapping("/add-a-fave")
    public String addAFavorite(Model model, HttpServletRequest request, HttpSession session){
        User user = getCurrentUser(request);

        model.addAttribute("user", userRepository.findById(user.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        model.addAttribute("title", "Add a Favorite");
        model.addAttribute(new Favorite());
        model.addAttribute("favoriteTags", favoriteTagRepository.findAll());
        return "favorite-Lou-Spots/add-a-fave";
    }

    @PostMapping("/add-a-fave")
    public String processAFavorite(HttpServletRequest request, HttpSession session, @ModelAttribute @Valid Favorite favorite, Model model, Errors errors){

        User user = getCurrentUser(request);
        model.addAttribute("loggedIn", session.getAttribute("user") != null);


     /*   if(errors.hasErrors()){
            model.addAttribute("title", "Add a Favorite");
            model.addAttribute(new Favorite());
            return "redirect:/favorite-Lou-Spots/add-a-fave";
        }*/

        favoritesRepository.save(favorite);
        return "redirect:/favorites";
    }

    @GetMapping("/tag-index")
    public String displayTags(Model model, HttpServletRequest request, HttpSession session, String keyword){
        User user = getCurrentUser(request);

        model.addAttribute("user", userRepository.findById(user.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        model.addAttribute("favoriteTags", favoriteTagRepository.findAll());

        return "favorite-Lou-Spots/tag-index";
    }

    @GetMapping("/create-tag")
    public String createTagForm(HttpServletRequest request, HttpSession session, Model model) {
        User user = getCurrentUser(request);
        model.addAttribute("user", userRepository.findById(user.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        model.addAttribute("title", "Create Tag");
        model.addAttribute(new FavoriteTag());
        return "favorite-Lou-Spots/add-a-tag";
    }

    @PostMapping("/create-tag")
    public String processCreateTagForm(HttpServletRequest request, HttpSession session, @Valid @ModelAttribute FavoriteTag favoriteTag,
                                                 Errors errors, Model model) {
        User user = getCurrentUser(request);
        model.addAttribute("user", userRepository.findById(user.getId()));
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        favoriteTagRepository.save(favoriteTag);
        return "redirect:/favorites";
    }

}
