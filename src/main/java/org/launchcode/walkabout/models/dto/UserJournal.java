package org.launchcode.walkabout.models.dto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.launchcode.walkabout.models.AbstractEntity;
import org.springframework.data.annotation.Id;

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

    /*@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "journalId")*/
    //int journalInt = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer journalId = 0;
    /*private static int newId=1;
    public int UserJournal(int journalId){
        return journalId=newId++;
    };*/

    public UserJournal(String userName, String journalEntryBlank, String journalLocation, String journalDate, String comments) {
        this.userName = userName;
        this.journalEntryBlank = journalEntryBlank;
        this.journalLocation = journalLocation;
        this.journalDate = journalDate;
        this.comments = comments;
    }

    public UserJournal() {
        this.userName = "";
        this.journalEntryBlank = "";
        this.journalLocation = "";
        this.journalDate = "";
        this.comments = "";
        this.journalId = 0;
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

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }
}
