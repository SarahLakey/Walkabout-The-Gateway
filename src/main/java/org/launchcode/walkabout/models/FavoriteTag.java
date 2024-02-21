package org.launchcode.walkabout.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FavoriteTag extends AbstractEntity {

    @NotBlank
    private String name;

    @OneToMany(mappedBy="favoriteTag")
    private final List<Favorite> favorites = new ArrayList<>();

    public FavoriteTag(String name){
        this.name=name;
    }
    public FavoriteTag(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public String getDisplayName() {
        return "#" + name;
    }

}
