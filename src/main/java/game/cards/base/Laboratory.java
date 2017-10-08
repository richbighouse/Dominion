package game.cards.base;

import game.cards.ActionCard;
import game.controller.Turn;

public class Laboratory extends ActionCard {

    @Override
    public int getCost() {
        return 5;
    }

    @Override
    public String getName() {
        return "Laboratory";
    }

    @Override
    public String getDescription() {
        return "+2 Cards\n+1 Action";
    }

    @Override
    public void playAction(Turn turn) {
        turn.moveFromHandToInPlay(this);
        turn.getPlayerDeck().drawCards(2);
        turn.addActions(1);
    }
}
