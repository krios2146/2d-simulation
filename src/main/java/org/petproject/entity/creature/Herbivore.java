package org.petproject.entity.creature;

import org.petproject.BreadthFirstSearch;
import org.petproject.Coordinates;
import org.petproject.entity.Grass;

import java.util.List;

public class Herbivore extends Creature {
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());
        Coordinates coordinatesToMove = wayToObject.get(speed - 1);
        this.setCoordinates(coordinatesToMove);
    }

    @Override
    public String toString() {
        return "H";
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
