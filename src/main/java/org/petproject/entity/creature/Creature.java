package org.petproject.entity.creature;

import org.petproject.entity.Entity;

public abstract class Creature extends Entity {
    int hp = 10;
    int speed = 1;

    public abstract void makeMove();
}
