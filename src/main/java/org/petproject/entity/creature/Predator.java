package org.petproject.entity.creature;

import org.petproject.BreadthFirstSearch;
import org.petproject.Coordinates;

import java.util.List;

public class Predator extends Creature {
    int attack;
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Herbivore());
        Coordinates coordinatesToMove = wayToObject.get(speed - 1);
        this.setCoordinates(coordinatesToMove);
    }

    @Override
    public String toString() {
        return "P";
    }
}
