package org.petproject.entity.creature;

import org.petproject.BreadthFirstSearch;
import org.petproject.Coordinates;
import org.petproject.entity.Entity;
import org.petproject.entity.Grass;
import org.petproject.entity.Ground;

import java.util.List;

import static org.petproject.Main.simulation;

public class Herbivore extends Creature {
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());

        if (wayToObject.size() == 1) {
            Coordinates coordinatesOfGrass = wayToObject.get(0);
            Entity[][] map = simulation.getMap().getMap();
            map[coordinatesOfGrass.getX()][coordinatesOfGrass.getY()] = new Ground(coordinatesOfGrass);
        }
        else {
            Coordinates coordinatesToMove = wayToObject.get(speed - 1);
            setCoordinates(coordinatesToMove);
        }
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
