package org.petproject.entity.creature;

import org.petproject.entity.Entity;

public abstract class Creature extends Entity {
    int hp;
    int speed;

    public abstract void makeMove();
}
