package org.launchcode.walkabout.models;

import jakarta.validation.constraints.NotNull;

import javax.persistence.Entity;

@Entity
public class SubmitFact extends AbstractEntity {

    @NotNull
    private String factInputBlank;

    @NotNull
    private String nameInput;

    @NotNull
    private String locationInput;

    @NotNull
    private String factInput;

    public SubmitFact(String nameInput, String locationInput, String factInput, String factInputBlank) {
        this.nameInput = nameInput;
        this.locationInput = locationInput;
        this.factInput = factInput;
        this.factInputBlank = factInputBlank;
    }

    public SubmitFact(String nameInput, String locationInput, String factInput) {
        this.nameInput = nameInput;
        this.locationInput = locationInput;
        this.factInput = factInput;
    }

    public SubmitFact() {
        this.nameInput = "";
        this.locationInput = "";
        this.factInputBlank = "";
    }


    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getLocationInput() {
        return locationInput;
    }

    public void setLocationInput(String locationInput) {
        this.locationInput = locationInput;
    }

    public String getFactInput() {
        return factInput;
    }

    public void setFactInput(String factInput) {
        this.factInput = factInput;
    }

    public String getFactInputBlank() {
        return factInputBlank;
    }

    public void setFactInputBlank(String factInputBlank) {
        this.factInputBlank = factInputBlank;
    }
}
