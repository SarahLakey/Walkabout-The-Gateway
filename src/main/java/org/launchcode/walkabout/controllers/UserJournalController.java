package org.launchcode.walkabout.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.launchcode.walkabout.data.UserRepository;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userjournal")
public class UserJournalController {
        /*@GetMapping
        public String userJournalController()

        {return "journalentries/userjournal";}*/

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private UserRepository userRepository;

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return authenticationController.getUserFromSession(session);

    }

    @GetMapping
    public String displayUserJournal(HttpServletRequest request, HttpSession session, Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        return "journalentries/userjournal";
    }


    @PostMapping("/log")
    public String processUserJournal(@Valid User user, Errors errors, Model model, HttpSession session, HttpServletRequest request) {
        User currentUser = getCurrentUser(request);


        currentUser.setJournalEntry(user.getJournalEntry() + currentUser.getJournalEntry());
        System.out.println("Journal Entries: " + currentUser.getJournalEntry() + currentUser.getJournalLocation() + currentUser.getJournalLocation());

        userRepository.save(currentUser);

        return "redirect:/profile";
    }
}

    /*private final JournalRepository journalRepository;

    public UserJournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }


    @GetMapping("/entries")
    public String userJournalController(Model model) {
        List<UserJournal> journalEntries = (List<UserJournal>) journalRepository.findAll();

        model.addAttribute("journalEntries", journalEntries);
        return "journalentries/userjournal";
    }

    @GetMapping("/form")
    public String userJournalForm(Model model) {
        model.addAttribute("userJournal", new UserJournal());
        return "journalentries/userjournal"; // Assuming this is your form template
    }

    @PostMapping("/submit")
    public String submitUserJournal(@ModelAttribute UserJournal userJournal, RedirectAttributes redirectAttributes) {
        // Save the submitted journal entry to the database
        journalRepository.save(userJournal);

        // Add a flash attribute to display a success message on the redirected page
        redirectAttributes.addFlashAttribute("successMessage", "Journal entry submitted successfully!");

        // Redirect to the same page to avoid form resubmission on page refresh
        return "redirect:/userjournal/form";
    }
}

/*@Controller
@RequestMapping("/userjournal")
public class UserJournalController {
    @GetMapping
    public String userJournalController(Model model) {
        // Create a new instance of journalEntry or fetch it from your data source
        UserJournal journalEntry = new UserJournal();

        // Add journalEntry to the model
        model.addAttribute("journalEntry", journalEntry);

        // Return the view name
        return "journalentries/userjournal";}

    private final JournalRepository journalRepository;

    public UserJournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }


    @GetMapping("/form")
    public String userJournalForm(Model model) {
        model.addAttribute("userJournal", new UserJournal());
        return "journalentries/userjournal"; // Assuming this is your form template
    }

    @PostMapping("/submit")
    public String submitUserJournal(@ModelAttribute UserJournal userJournal, RedirectAttributes redirectAttributes) {
        // Save the submitted journal entry to the database
        journalRepository.save(userJournal);

        // Add a flash attribute to display a success message on the redirected page
        redirectAttributes.addFlashAttribute("successMessage", "Journal entry submitted successfully!");

        // Redirect to the same page to avoid form resubmission on page refresh
        return "redirect:/userjournal/form";
    }
}

/*@Controller
@RequestMapping("/userjournal")
public class UserJournalController {

    private final JournalRepository journalRepository;

    public UserJournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @GetMapping
    public String userJournalForm(Model model) {
        model.addAttribute("userJournal", new UserJournal());
        return "journalentries/userjournal"; // Assuming this is your form template
    }

    @PostMapping
    public String submitUserJournal(@ModelAttribute UserJournal userJournal, RedirectAttributes redirectAttributes) {
        // Save the submitted journal entry to the database
        journalRepository.save(userJournal);

        // Add a flash attribute to display a success message on the redirected page
        redirectAttributes.addFlashAttribute("successMessage", "Journal entry submitted successfully!");

        // Redirect to the same page to avoid form resubmission on page refresh
        return "redirect:/userjournal";
    }
}

/*@Controller
@RequestMapping("userjournal")
public class UserJournalController {

    @Autowired
    JournalRepository journalRepository;


    @GetMapping
    public String userJournalController(Model model) {
        model.addAttribute("userJournal", new UserJournal());
        return "journalentries/userjournal";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute UserJournal userJournal, Model model) {
        // Process the submitted form data
        // You can save the data to a database or perform any other necessary operations here
        // For demonstration purposes, let's just print the data
        System.out.println("Submitted Journal Entry: " + userJournal.getJournalEntry());
        System.out.println("Submitted Journal Location: " + userJournal.getJournalLocation());
        System.out.println("Submitted Journal Date: " + userJournal.getJournalDate());

        // Assuming you want to display the submitted data on the same page
        model.addAttribute("submittedJournal", userJournal);
        return "journalentries/readjournals";
    }
}

/*@Controller
@RequestMapping("userjournal")
public class UserJournalController {

    // Existing method to display the form
    @GetMapping
    public String userJournalController() {
        return "journalentries/userjournal";
    }

    // Method to handle form submission and redirect
    @PostMapping("/submit")
    public String submitForm(@RequestParam String name, @RequestParam String journalsub, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("journalsub", journalsub);
        return "redirect:/userjournal/view"; // Redirect after form submission
    }

    // Method to handle the redirected request
    @GetMapping("/view")
    public String viewSubmittedData() {
        return "journalentries/view"; // Assuming "view" is the name of your view template
    }
}

/*@Controller
//@RequestMapping("userjournal")
public class UserJournalController{

  /* @GetMapping
    public String userJournalController()

    {return "journalentries/userjournal";}

    @Autowired
    private JournalRepository journalRepository;

    @GetMapping
    public String userJournalController(Model model) {
        Iterable<UserJournal> journalEntries = journalRepository.findAll();
        model.addAttribute("journalEntries", journalEntries);
        return "journalentries/userjournal";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String journalEntry,
                             @RequestParam String journalLocation,
                             @RequestParam String journalDate) {
        UserJournal newEntry = new UserJournal(journalEntry, journalLocation, journalDate);
        journalRepository.save(newEntry);
        return "redirect:/userjournal/view";
    }}


   /* @GetMapping
    public String userJournalController()

    {return "journalentries/userjournal";}
}


/*@Controller
@RequestMapping("/userjournal")
public class UserJournalController {

    @GetMapping("/userjournal")
    public String showForm() {
        return "userjournal";
    }

    @PostMapping("/userjournal")
    public String submitForm(@RequestParam String name, @RequestParam String journalsub, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("journalsub", journalsub);
        return "userjournal";
    }
}
/*@Controller
@RequestMapping("/userjournal")
public class UserJournalController{

    @GetMapping
    public String userJournalController()

    {return "journalentries/userjournal";}

    @GetMapping("/form")
    public String showForm() {
        return "/userjournal/userjournal";
    }

    @PostMapping("/readjournals")
    public String submitForm(@RequestParam String name, @RequestParam String journalsub, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("journalsub", journalsub);
        return "readjournals";
    }
}

   /* @GetMapping
    public String userJournalController()

    {return "journalentries/userjournal";}
}

   /*public UserJournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @Autowired
    private final JournalRepository journalRepository;

   private UserJournal getJournalEntry(HttpServletRequest request) {
       HttpSession session = request.getSession();
       return journalRepository.getAttribute(UserJournal);
   } */


    /*@RequestMapping(value = "journalTemp", method = RequestMethod.GET)
    public String journalTemps(Model model) {
        model.addAttribute("journalTemps", JournalRepository.findall());
        return "journalTemp/list";
    }

    @RequestMapping(value = "journalTemp", method = RequestMethod.GET)
    public ModelAndView journaltemps() {
        ModelAndView mav = new ModelAndView("journalTemp/list");
        mav.addObject("journalTemps", JournalRepository.findall());
        return mav;
    }

    @ModelAttribute("journalTemps")
    public Object journalTemps() {
        return JournalRepository.findall();
    }

    /*@GetMapping("/userjournal")
    public List<UserJournal> getJournalEntry() {
        return (List<UserJournal>) journalRepository.findAll();
    }

    @PostMapping("/userjournal")
    void addJournal (@RequestBody UserJournal userJournal) {
        journalRepository.save(userJournal);
    }

   /* @GetMapping
    public String displayAllEventForm(Model model) {
        model.addAttribute("title", "All Journals");
        model.addAttribute("userJournals", userJournalsEvents);
        return "userjournal/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title","Create Journal");
        return "userjournal/create";
    }

   @PostMapping("create")
    public String processCreateEventForm(@RequestParam String journalEntry){
        userJournalsEvents.add(new UserJournal());
        return "redirect";
    }*/



    /*@Autowired
    private JournalRepository journalRepository;

    @PostMapping(path="/add")
    public @ResponseBody String createNewJournal(@RequestParam String journalEntry, @RequestParam String journalLocation, @RequestParam String journalDate){
    UserJournal n = new UserJournal();
    n.setJournalEntry(journalEntry);
    n.setJournalLocation(journalLocation);
    n.setJournalDate(journalDate);
    journalRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserJournal> getAllUserJournals() {
        return journalRepository.findAll();
    } */

    /*@RequestMapping(value = "/userjournal", method = RequestMethod.POST)
    public String userJournalSubmit(@ModelAttribute UserJournal userJournal, Model model){
        model.addAttribute("userjournal", userJournal);
        return "result";
    }*/

