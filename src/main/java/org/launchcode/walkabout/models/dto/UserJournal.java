package org.launchcode.walkabout.models.dto;
import jakarta.persistence.*;
import org.launchcode.walkabout.models.AbstractEntity;

@Entity
public class UserJournal{

    @Id
    public Integer Id;
    private String journalEntry;
    private String journalLocation;

    public UserJournal(String journalEntry, String journalLocation) {
        this.journalEntry = journalEntry;
        this.journalLocation =journalLocation;
    }

    public String getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(String journalEntry) {
        this.journalEntry = journalEntry;
    }

    public String getJournalLocation() {
        return journalLocation;
    }

    public void setJournalLocation(String journalLocation) {
        this.journalLocation = journalLocation;
    }

    @Override
    public String toString(){
        return journalEntry;
    }

    /* @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String journalEntry;
   private String journalLocation;

   private String journalDate;

    /*public UserJournal(Integer id, String journalEntry, String journalLocation, String journalDate) {
        Id = id;
        this.journalEntry = journalEntry;
        this.journalLocation = journalLocation;
        this.journalDate = journalDate;
    }

    public UserJournal() {

    }

    public int getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(String journalEntry) {
        this.journalEntry = journalEntry;
    }

    public String getJournalLocation() {
        return journalLocation;
    }

    public void setJournalLocation(String journalLocation) {
        this.journalLocation = journalLocation;
    }

    public String getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(String journalDate) {
        this.journalDate = journalDate;
    } */


    /* @NotBlank(message = "Please add the journal entry.")
    @Min(1)
    private String journalEntry;

    @NotBlank(message = "Please add the journal location.")
    @Min(3)
    private String journalLocation;

    @NotNull(message = "Please add the journal date.")
    private static LocalDateTime journalDate;

    public UserJournal(String journalEntry, String journalLocation, LocalDateTime journalDate) {
        this.journalEntry = journalEntry;
        this.journalLocation = journalLocation;
        UserJournal.journalDate = journalDate;
    }

    @Autowired
    public UserJournal() {}


    public String getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(String journalEntry) {
        this.journalEntry = journalEntry;
    }

    public String getJournalLocation() {
        return journalLocation;
    }

    public void setJournalLocation(String journalLocation) {
        this.journalLocation = journalLocation;
    }

    public LocalDateTime getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(LocalDateTime journalDate) {
        UserJournal.journalDate = journalDate;
    }

    public String toString(){
        return journalEntry + journalLocation + journalDate;
    }

   @PostMapping("/userjournal")
    public UserJournal createNewJournalEntry(String journalEntry, String journalLocation, LocalDateTime journalDate){
        UserJournal tempJournal = new UserJournal(journalEntry, journalLocation, journalDate);
        System.out.println(tempJournal);
        return tempJournal;
    };

    @GetMapping("/userjournal")
    public String newJournal(Model model) {
        model.addAttribute("journal", journalEntry);
        return "newJournal.html";
    }*/

}
