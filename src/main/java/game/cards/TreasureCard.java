package game.cards;

import game.controller.Turn;

public abstract class TreasureCard extends Card {

    public abstract int getCoins();

    public abstract void playTreasure(Turn turn);

}
