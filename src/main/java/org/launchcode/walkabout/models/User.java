package org.launchcode.walkabout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private Integer points = 0;

    @ManyToOne
    private Favorite favorites;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(String firstName, String username, String password) {
        this.firstName = firstName;
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

   public boolean isMatchingPassword (String password) {
        return encoder.matches(password, pwHash);
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Favorite getFavorites(){
        return favorites;
    }

    public void setFavorites(Favorite favorites){
        this.favorites=favorites;
    }


}
