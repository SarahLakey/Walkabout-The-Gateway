package authentication.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    public User() {}



}
