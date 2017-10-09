package game.controller;

import game.player.Player;

import java.util.List;

public class GameController {

    private static GameController instance = null;

    private List<Player> players;

    private GameController() {
    }

    public GameController getInstance() {
        if(instance == null) {
            instance = new GameController();
        }
        return instance;
    }
}
