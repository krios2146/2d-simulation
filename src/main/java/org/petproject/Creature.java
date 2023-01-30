package org.petproject;

public abstract class Creature extends Entity {
    int hp;
    int speed;

    public abstract void makeMove();
}
