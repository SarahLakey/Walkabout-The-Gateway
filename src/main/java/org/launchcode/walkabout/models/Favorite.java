package org.launchcode.walkabout.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;

@Entity
public class Favorite extends User {

    @NotBlank(message = "Name required- put a name to that place!")
    private String location;

    @NotBlank(message = "Find the coordinates in the Display Map tab!")
    private int longitude;
    @NotBlank(message = "Find the coordinates in the Display Map tab!")
    private int latitude;

    private String description;

    public Favorite(String location, int longitude, int latitude, String description){
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
    }

    public Favorite() {};

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
