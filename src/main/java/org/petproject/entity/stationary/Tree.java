package org.petproject.entity.stationary;

import org.petproject.Coordinates;

public class Tree extends Stationary {
    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Tree() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return "🌲";
    }
}
