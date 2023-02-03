package org.petproject;

import org.petproject.creature.Herbivore;
import org.petproject.creature.Predator;
import org.petproject.entity.*;

import java.util.Random;

public class Map {
    private Entity[][] map;

    /**
     * Create a map of given x and y size, filled with Ground objects
     * @param x - horizontal size of a map
     * @param y - vertical size of a map
     */
    public void initEmptyMap(int x, int y) {
        this.map = new Entity[x][y];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = new Ground(new Coordinates(i, j));
            }
        }
    }

    /**
     * Fill given map with all the available in simulation objects in random way
     * @param map to fill with objects
     * @return map filled with objects
     */
    public Entity[][] fillMapWithRandomObjects(Entity[][] map) {
        int[] objectsPool = createPoolOfObjectsForMap(map);

        for (int i = 0; i < objectsPool.length; i++) {
            for (int j = 0; j < objectsPool[i]; j++) {
                Entity entity = null;

                if (i == 0) {
                    entity = new Grass();
                }
                if (i == 1) {
                    entity = new Herbivore();
                }
                if (i == 2) {
                    entity = new Predator();
                }
                if (i == 3) {
                    entity = new Tree();
                }
                if (i == 4) {
                    entity = new Rock();
                }

                Coordinates randomCoordinates = randomizeCoordinatesOfObject(entity);
                entity.setCoordinates(randomCoordinates);

                addObject(entity);
            }
        }

        return map;
    }

    public void addObject(Entity object) {
        Coordinates coordinates = object.getCoordinates();
        map[coordinates.x][coordinates.y] = object;
    }

    /**
     * Create a pool of the objects that should be placed into the map
     * @param map for which pool should be created
     * @return array of ints in which each of the number represent
     * amount of objects that should be created in the following order -
     * Grass, Herbivore, Predator, Tree, Rock
     */
    private int[] createPoolOfObjectsForMap(Entity[][] map) {
        int x = map.length;
        int y = map[0].length;
        int mapArea = x * y;

        int amountOfGrass = mapArea / 2;
        int amountOfHerbivores = amountOfGrass / 10;
        int amountOfPredators = amountOfHerbivores / 10;
        int amountOfTress = amountOfGrass / 10;
        int amountOfRocks = amountOfGrass / 10;

        return new int[]{amountOfGrass, amountOfHerbivores, amountOfPredators, amountOfTress, amountOfRocks};
    }

    private Coordinates randomizeCoordinatesOfObject(Entity entity) {
        int xUpperBound = map.length;
        int yUpperBound = map[0].length;

        Random random = new Random();

        int randomX = random.nextInt(xUpperBound);
        int randomY = random.nextInt(yUpperBound);

        return new Coordinates(randomX, randomY);
    }
}
