package game.controller;

import game.cards.Card;
import game.player.Player;

import java.util.List;

public abstract class Turn {

    private int coins;
    private int buys;
    private int actions;
    private List<Card> inPlay;
    private Player player;


}
