package game.cards.base;

import game.cards.TreasureCard;
import game.controller.Turn;

public class Copper extends TreasureCard {

    @Override
    public int getCoins() {
        return 1;
    }

    @Override
    public void playTreasure(Turn turn) {
        turn.addCoins(this.getCoins());
        turn.moveFromHandToInPlay(this);
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String getName() {
        return "Copper";
    }

    @Override
    public String getDescription() {
        return "Worth 1 Coin";
    }
}
