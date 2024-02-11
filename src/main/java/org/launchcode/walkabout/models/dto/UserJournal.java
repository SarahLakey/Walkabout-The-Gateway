package org.launchcode.walkabout.models.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.launchcode.walkabout.models.AbstractEntity;
import org.launchcode.walkabout.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Scanner;

@Entity
public class UserJournal extends AbstractEntity {

    @NotBlank(message = "Please add the journal entry.")
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

   @RequestMapping("/userjournal")
    public UserJournal createNewJournalEntry(@RequestParam String journalEntry, String journalLocation, LocalDateTime journalDate){
        UserJournal tempJournal = new UserJournal(journalEntry, journalLocation, journalDate);

        return tempJournal;
    };

}
