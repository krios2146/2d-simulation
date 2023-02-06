package org.petproject.entity.stationary;

import org.petproject.Coordinates;
import org.petproject.entity.stationary.Stationary;

public class Tree extends Stationary {
    private final Coordinates coordinates;

    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Tree() {
        this.coordinates = new Coordinates();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "T";
    }
}
