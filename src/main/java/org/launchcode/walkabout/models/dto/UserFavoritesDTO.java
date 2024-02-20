package org.launchcode.walkabout.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserFavoritesDTO {

    @NotBlank(message = "Name required- put a name to that place!")
    @Min(3)
    private String location;

    @NotBlank(message = "Find the coordinates in the Display Map tab!")
    @Min(6)
    private String longitude;
    @NotBlank(message = "Find the coordinates in the Display Map tab!")
    @Min(6)
    private String latitude;

    private String description;

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
}
