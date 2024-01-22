package src.main.java.org.launchcode.walkabout.models.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UserJournal {
    private String journalEntry;
    private String journalLocation;
    private LocalDateTime journalDate;

    public UserJournal(String journalEntry, String journalLocation, LocalDateTime journalDate) {
        this.journalEntry = journalEntry;
        this.journalLocation = journalLocation;
        this.journalDate = journalDate;
    }

    public UserJournal() {
        this.journalEntry = "";
        this.journalLocation = "";
        this.journalDate = null;
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

    public LocalDateTime getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(LocalDateTime journalDate) {
        this.journalDate = journalDate;
    }

    public UserJournal createNewJournalEntry(){
        UserJournal tempJournal = new UserJournal();
        Scanner tempScanner = new Scanner(System.in);
        System.out.println("Please enter your journal entry: ");

        tempJournal.setJournalEntry(tempScanner.nextLine());
        tempJournal.setJournalDate(LocalDateTime.now());
        return tempJournal;
    }

}
