package game.cards.base;

import game.cards.ActionCard;
import game.controller.Turn;

public class Village extends ActionCard {
    @Override
    public int getCost() {
        return 3;
    }

    @Override
    public String getName() {
        return "Village";
    }

    @Override
    public String getDescription() {
        return "+1 Card \n+2Actions";
    }

    @Override
    public void playAction(Turn turn) {
        turn.moveFromHandToInPlay(this);
        turn.getPlayerDeck().drawCards(1);
        turn.addActions(2);
    }
}
