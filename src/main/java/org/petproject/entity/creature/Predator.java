package org.petproject.entity.creature;

import org.petproject.BreadthFirstSearch;
import org.petproject.Coordinates;
import org.petproject.entity.Entity;

import java.util.List;

import static org.petproject.Main.simulation;

public class Predator extends Creature {
    int attack;
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Herbivore());

        if (wayToObject.size() == 1) {
            Coordinates coordinatesOfHerbivore = wayToObject.get(0);
            Entity[][] map = simulation.getMap().getMap();
            Herbivore herbivore = (Herbivore) map[coordinatesOfHerbivore.getX()][coordinatesOfHerbivore.getY()];
            int herbivoreHp = herbivore.getHp();
            herbivore.setHp(herbivoreHp - attack);
        }
        else {
            Coordinates coordinatesToMove = wayToObject.get(speed - 1);
            setCoordinates(coordinatesToMove);
        }
    }

    @Override
    public String toString() {
        return "P";
    }
}
