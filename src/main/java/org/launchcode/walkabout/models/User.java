package org.launchcode.walkabout.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

   public boolean isMatchingPassword (String password) {
        return encoder.matches(password, pwHash);
    }

   private String journalEntry="";

    public String getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(String journalEntry) {
        this.journalEntry = journalEntry;
    }

    private String journalLocation="";

    public String getJournalLocation() {
        return journalLocation;
    }

    public void setJournalLocation(String journalLocation) {
        this.journalLocation = journalLocation;
    }

    public static Date journalDate;

    public Date getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(Date journalDate) {
        User.journalDate = journalDate;
    }
}
