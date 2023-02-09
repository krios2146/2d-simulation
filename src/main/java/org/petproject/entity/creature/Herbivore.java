package org.petproject.entity.creature;

import org.petproject.BreadthFirstSearch;
import org.petproject.Coordinates;
import org.petproject.entity.Entity;
import org.petproject.entity.Grass;
import org.petproject.entity.Ground;

import java.util.List;

import static org.petproject.Main.simulation;

public class Herbivore extends Creature {
    private BreadthFirstSearch breadthFirstSearch;

    @Override
    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());

        if (wayToObject.size() == 1) {
            eatGrass(wayToObject);
        }
        else {
            moveToGrass(wayToObject);
        }
    }

    private void moveToGrass(List<Coordinates> wayToObject) {
        // Remove herbivore from it current coordinates
        Entity[][] map = simulation.getMap().getMap();
        map[coordinates.getX()][coordinates.getY()] = new Ground(new Coordinates(coordinates.getX(), coordinates.getY()));
        // Set new coordinates to herbivore
        Coordinates coordinatesToMove = wayToObject.get(speed - 1);
        setCoordinates(coordinatesToMove);
    }

    private static void eatGrass(List<Coordinates> wayToObject) {
        Coordinates coordinatesOfGrass = wayToObject.get(0);
        Entity[][] map = simulation.getMap().getMap();
        map[coordinatesOfGrass.getX()][coordinatesOfGrass.getY()] = new Ground(coordinatesOfGrass);
    }

    @Override
    public String toString() {
        return "🐔";
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
