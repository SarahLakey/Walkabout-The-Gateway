package org.launchcode.walkabout.models;

import jakarta.persistence.Entity;

@Entity
public class ExperiencePoints extends AbstractEntity {
    private int Points;

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }
}
