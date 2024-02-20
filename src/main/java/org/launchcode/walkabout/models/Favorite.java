package org.launchcode.walkabout.models;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.launchcode.walkabout.models.dto.UserJournal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
public class Favorite extends AbstractEntity {

    @OneToMany(mappedBy="favorites")
    private final List<User> userFaves = new ArrayList<>();

    @NotBlank(message = "Name required- put a name to that place!")
    private String location;

    @NotBlank(message = "Find the coordinates in the Display Map tab!")
    private String longitude;
    @NotBlank(message = "Find the coordinates in the Display Map tab!")
    private String latitude;

    private String description;

    public Favorite(String location, String longitude, String latitude, String description){
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUserFaves(){
        return userFaves;
    }

    @Override
    public String toString(){return location + longitude + latitude + description;}

}
