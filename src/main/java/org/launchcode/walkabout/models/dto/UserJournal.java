package org.launchcode.walkabout.models.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Scanner;


public class UserJournal{

    @NotBlank(message = "Please add the journal entry.")
    @Min(0)
    private String journalEntry;

    @NotBlank(message = "Please add the journal location.")
    @Min(0)
    private String journalLocation;

    @NotNull(message = "Please add the journal date.")
    private static LocalDateTime journalDate;

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

    @Override
    public String toString(){
        return journalEntry + journalLocation + journalDate;
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
