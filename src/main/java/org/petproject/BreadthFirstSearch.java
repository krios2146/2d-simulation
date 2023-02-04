package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;

import java.util.List;

public class BreadthFirstSearch {

    private Simulation simulation;
    private Entity[][] map;
    private List<Coordinates> queuedCoordinates;
    private List<Coordinates> exploredCoordinates;
    private Creature objectToFind;

    public Coordinates findClosestObjectCoordinates(Coordinates currentCoordinates, Creature objectToFind) {
        this.map = simulation.getMap().getMap();
        this.objectToFind = objectToFind;

        queuedCoordinates.add(currentCoordinates);

        return exploreQueuedObjects();
    }

    private Coordinates exploreQueuedObjects() {
        Coordinates coordinatesOfDesiredObject = null;

        for (Coordinates coordinate : queuedCoordinates) {
            Entity object = map[coordinate.x][coordinate.y];

            if (object.getClass().equals(objectToFind.getClass())) {
                coordinatesOfDesiredObject = coordinate;
            }

            queuedCoordinates.remove(coordinate);
            exploredCoordinates.add(coordinate);

            findEnqueuedCoordinates(coordinate);
        }

        if (coordinatesOfDesiredObject == null) {
            exploreQueuedObjects();
        }

        return coordinatesOfDesiredObject;
    }

    private void findEnqueuedCoordinates(Coordinates coordinates) {
        int startX = coordinates.x - 1;
        int endX = coordinates.x + 1;
        int startY = coordinates.y - 1;
        int endY = coordinates.y + 1;

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; i <= endY; i++) {
                Coordinates coordinatesOfEnqueuedObject = new Coordinates(i, j);

                if (!queuedCoordinates.contains(coordinatesOfEnqueuedObject) && !exploredCoordinates.contains(coordinatesOfEnqueuedObject)) {
                    queuedCoordinates.add(coordinatesOfEnqueuedObject);
                }
            }
        }
    }
}
