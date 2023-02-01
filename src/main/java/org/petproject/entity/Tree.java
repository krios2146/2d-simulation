package org.petproject.entity;

import org.petproject.Coordinates;

public class Tree extends Entity {
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
