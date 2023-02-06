package org.petproject.entity.stationary;

import org.petproject.Coordinates;

public class Rock extends Stationary {
    private final Coordinates coordinates;

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Rock() {
        this.coordinates = new Coordinates();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "R";
    }
}
