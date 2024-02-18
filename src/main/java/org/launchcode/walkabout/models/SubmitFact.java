package org.launchcode.walkabout.models;

import javax.persistence.Entity;

@Entity
public class SubmitFact {

    private String nameInput;
    private String locationInput;
    private String factInput;

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
}
