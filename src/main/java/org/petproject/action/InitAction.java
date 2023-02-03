package org.petproject.action;

import org.petproject.Coordinates;
import org.petproject.Map;
import org.petproject.entity.Entity;
import org.petproject.entity.Grass;
import org.petproject.entity.Rock;
import org.petproject.entity.Tree;
import org.petproject.entity.creature.Herbivore;
import org.petproject.entity.creature.Predator;

import java.util.HashMap;
import java.util.Random;

public class InitAction extends Action {

    private Map map;

    public Map initMap() {
        map = new Map();

        HashMap<Entity, Integer> pool = createObjectPoolForMap(map);

        pool.forEach((entity, amountOfEntity) -> {
            for (int i = 0; i < amountOfEntity; i++) {
                Entity entityWithRandomCoordinates = assignRandomCoordinatesToEntity(entity);
                map.addObject(entityWithRandomCoordinates);
            }
        });

        return map;
    }

    /**
     * Creates a pool of objects for a given map.
     * <p>
     * This method uses the size of the map to calculate the total area and the amount of each type of object (Grass, Herbivore, Predator, Tree, Rock) that should be created. These amounts are then stored as key-value pairs in a `HashMap`, with the object as the key and the amount as the value. The resulting `HashMap` is returned.
     *
     * @param map The map for which the object pool is being created.
     * @return A `HashMap` containing the objects and their corresponding amounts.
     */
    private HashMap<Entity, Integer> createObjectPoolForMap(Map map) {
        HashMap<Entity, Integer> pool = new HashMap<>();

        int x = map.getMap().length;
        int y = map.getMap()[0].length;
        int mapArea = x * y;

        int amountOfGrass = mapArea / 2;
        pool.put(new Grass(), amountOfGrass);

        int amountOfHerbivores = amountOfGrass / 10;
        pool.put(new Herbivore(), amountOfHerbivores);

        int amountOfPredators = amountOfHerbivores / 10;
        pool.put(new Predator(), amountOfPredators);

        int amountOfTress = amountOfGrass / 10;
        pool.put(new Tree(), amountOfTress);

        int amountOfRocks = amountOfGrass / 10;
        pool.put(new Rock(), amountOfRocks);

        return pool;
    }

    /**
     * Assigns random coordinates to a given entity.
     * <p>
     * This method uses the length and width of the map to determine the upper bounds for the x and y coordinates. A `java.util.Random` object is used to generate random values within these bounds. The resulting x and y coordinates are used to create a `Coordinates` object, which is then set as the entity's coordinates. The entity with its updated coordinates is returned.
     *
     * @param entity The entity for which the random coordinates are being assigned.
     * @return The same entity with updated `Coordinates` containing randomly generated x and y values within the bounds of the map.
     */
    private Entity assignRandomCoordinatesToEntity(Entity entity) {
        int xUpperBound = map.getMap().length;
        int yUpperBound = map.getMap()[0].length;

        Random random = new Random();

        int randomX = random.nextInt(xUpperBound);
        int randomY = random.nextInt(yUpperBound);

        Coordinates coordinates = new Coordinates(randomX, randomY);

        entity.setCoordinates(coordinates);
        return entity;
    }
}
