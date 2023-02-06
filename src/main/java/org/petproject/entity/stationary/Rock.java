package org.petproject.entity.stationary;

import org.petproject.Coordinates;

public class Rock extends Stationary {
    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Rock() {
        coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return "R";
    }
}
