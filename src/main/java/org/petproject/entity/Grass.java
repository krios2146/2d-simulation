package org.petproject.entity;

import org.petproject.Coordinates;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Grass() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return "●";
    }
}
