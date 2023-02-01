package org.petproject.entity;

import org.petproject.Coordinates;

public class Rock extends Entity {
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
