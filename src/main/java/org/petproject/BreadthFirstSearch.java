package org.petproject;

import org.petproject.entity.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BreadthFirstSearch {

    private Simulation simulation;
    private Entity[][] map;
    private List<Coordinates> queuedCoordinates;
    private List<Coordinates> exploredCoordinates;
    private Entity objectToFind;
    private HashMap<Coordinates, Coordinates> childParentMap = new HashMap<>();
    private int graphDepth = 0;

    public List<Coordinates> findClosestObjectCoordinates(Coordinates currentCoordinates, Entity objectToFind) {
        this.map = simulation.getMap().getMap();
        this.objectToFind = objectToFind;

        queuedCoordinates.add(currentCoordinates);

        Coordinates coordinatesOfDesiredObject = exploreQueuedObjects();

        return findWayToObject(coordinatesOfDesiredObject);
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

            graphDepth++;
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
                    childParentMap.put(coordinatesOfEnqueuedObject, coordinates);
                    queuedCoordinates.add(coordinatesOfEnqueuedObject);
                }
            }
        }
    }

    private List<Coordinates> findWayToObject(Coordinates coordinatesOfDesiredObject) {
        List<Coordinates> way = new ArrayList<>(graphDepth);

        for (int i = graphDepth; i > 0; i--) {
            Coordinates coordinates = childParentMap.get(coordinatesOfDesiredObject);
            way.add(coordinates);
        }

        way = way.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        return way;
    }
}
