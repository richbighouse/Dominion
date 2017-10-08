package game.cards.base;

import game.cards.ActionCard;
import game.controller.Turn;

public class Festival extends ActionCard {
    @Override
    public int getCost() {
        return 5;
    }

    @Override
    public String getName() {
        return "Festival";
    }

    @Override
    public String getDescription() {
        return "+2 Actions\n+1 Buy\n+2 $";
    }

    @Override
    public void playAction(Turn turn) {
        turn.moveFromHandToInPlay(this);
        turn.addActions(2);
        turn.addBuys(1);
        turn.addCoins(2);
    }
}
