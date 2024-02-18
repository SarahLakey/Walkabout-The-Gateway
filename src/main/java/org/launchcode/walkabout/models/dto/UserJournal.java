package org.launchcode.walkabout.models.dto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.launchcode.walkabout.models.AbstractEntity;

import java.util.List;

@Entity
public class UserJournal extends AbstractEntity{

    @NotNull
    private String journalEntryBlank;

    @NotNull
    private String journalLocation;

    @NotNull
    private String journalDate;

    @NotNull
    private String userName;

    private String comments;

    public UserJournal(String userName, String journalEntryBlank, String journalLocation, String journalDate) {
        this.userName = userName;
        this.journalEntryBlank = journalEntryBlank;
        this.journalLocation = journalLocation;
        this.journalDate = journalDate;
    }

    public UserJournal() {
        this.userName = "";
        this.journalEntryBlank = "";
        this.journalLocation = "";
        this.journalDate = "";
    }


    public String getJournalEntryBlank() {
        return journalEntryBlank;
    }

    public void setJournalEntryBlank(String journalEntryBlank) {
        this.journalEntryBlank = journalEntryBlank;
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
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public UserJournal(String comments) {
        this.comments = comments;
    }
}
