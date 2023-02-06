package org.petproject;

import org.petproject.action.InitAction;
import org.petproject.action.TurnAction;

public class Simulation {
    private Map map;
    private final InitAction initAction = new InitAction();
    private final TurnAction turnAction = new TurnAction();
    private Renderer renderer;
    private int movesCounter = 0;
    private boolean isGameStopped = false;

    public void nextTurn() {
        turnAction.processCreatureMoves(map);
    }

    public void startSimulation() {
        map = initAction.initMap();

        while (!isGameStopped) {
            nextTurn();

            movesCounter++;
        }
    }

    public void stopSimulation() {
        isGameStopped = true;
    }

    public Map getMap() {
        return map;
    }
}
