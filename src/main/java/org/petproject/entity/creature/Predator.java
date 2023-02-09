package org.petproject.entity.creature;

import org.petproject.BreadthFirstSearch;
import org.petproject.Coordinates;
import org.petproject.entity.Entity;
import org.petproject.entity.Ground;

import java.util.List;

import static org.petproject.Main.simulation;

public class Predator extends Creature {
    int attack = 5;
    private BreadthFirstSearch breadthFirstSearch;

    @Override
    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Herbivore());

        if (wayToObject.size() == 1) {
            attackHerbivore(wayToObject);
        } else {
            moveToHerbivore(wayToObject);
        }
    }

    private void moveToHerbivore(List<Coordinates> wayToObject) {
        // Remove predator from it current coordinates
        Entity[][] map = simulation.getMap().getMap();
        map[coordinates.getX()][coordinates.getY()] = new Ground(new Coordinates(coordinates.getX(), coordinates.getY()));
        // Set new coordinates to predator
        Coordinates coordinatesToMove = wayToObject.get(0);

        if (map[coordinatesToMove.getX()][coordinatesToMove.getY()].getClass().equals(Creature.class)) {
            coordinatesToMove = coordinates;
        }

        Predator predator = new Predator();
        predator.setCoordinates(coordinatesToMove);
        simulation.getMap().addObject(predator);
    }

    private void attackHerbivore(List<Coordinates> wayToObject) {
        Coordinates coordinatesOfHerbivore = wayToObject.get(0);
        Entity[][] map = simulation.getMap().getMap();
        Herbivore herbivore = (Herbivore) map[coordinatesOfHerbivore.getX()][coordinatesOfHerbivore.getY()];
        int herbivoreHp = herbivore.getHp();
        herbivore.setHp(herbivoreHp - attack);

        if (herbivore.getHp() <= 0) {
            map[coordinatesOfHerbivore.getX()][coordinatesOfHerbivore.getY()] = new Ground();
        }
    }

    @Override
    public String toString() {
        return "🦊";
    }
}
