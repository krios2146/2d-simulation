package org.petproject.entity;

import org.petproject.Coordinates;

public class Ground extends Entity {
    public Ground(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Ground() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return "G";
    }
}
