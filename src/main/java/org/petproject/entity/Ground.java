package org.petproject.entity;

import org.petproject.Coordinates;

public class Ground extends Entity {
    private Coordinates coordinates;

    public Ground(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Ground() {
        this.coordinates = new Coordinates();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "G";
    }
}
