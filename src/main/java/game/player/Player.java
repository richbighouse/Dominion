package game.player;

import game.cards.Card;

import java.util.List;

public abstract class Player {

    private String name;
    private Deck deck;

    public Player() {
        this.deck = new Deck();
    }


}
