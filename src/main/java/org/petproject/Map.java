package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.Ground;

import java.util.Arrays;

public class Map {
    private Entity[][] map;

    public void initMap(int x, int y) {
        this.map = new Entity[x][y];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = new Ground(new Coordinates(i, j));
            }
        }

        System.out.println(Arrays.deepToString(map));
    }
}
