package game.cards;

import game.controller.Turn;

public abstract class ActionCard extends Card {

    public abstract void playAction(Turn turn);
}
