package game.cards.base;

import game.cards.ActionCard;
import game.controller.Turn;

public class Smithy extends ActionCard {
    @Override
    public int getCost() {
        return 4;
    }

    @Override
    public String getName() {
        return "Smithy";
    }

    @Override
    public String getDescription() {
        return "+3 Cards";
    }

    @Override
    public void playAction(Turn turn) {
        turn.moveFromHandToInPlay(this);
        turn.getPlayerDeck().drawCards(3);
    }
}
