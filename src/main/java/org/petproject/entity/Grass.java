package org.petproject.entity;

import org.petproject.Coordinates;

public class Grass extends Entity {
    private Coordinates coordinates;

    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Grass() {
        this.coordinates = new Coordinates();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "●";
    }
}
