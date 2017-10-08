package game.cards.base;

import game.cards.TreasureCard;
import game.controller.Turn;

public class Silver extends TreasureCard {


    @Override
    public int getCoins() {
        return 2;
    }

    @Override
    public void playTreasure(Turn turn) {
        turn.addCoins(this.getCoins());
        turn.moveFromHandToInPlay(this);
    }

    @Override
    public int getCost() {
        return 3;
    }

    @Override
    public String getName() {
        return "Silver";
    }

    @Override
    public String getDescription() {
        return "Worth 2 Coins";
    }
}
