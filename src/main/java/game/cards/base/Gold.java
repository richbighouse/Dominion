package game.cards.base;

import game.cards.TreasureCard;
import game.controller.Turn;

public class Gold extends TreasureCard {

    @Override
    public int getCoins() {
        return 3;
    }

    @Override
    public void playTreasure(Turn turn) {
        turn.addCoins(this.getCoins());
        turn.moveFromHandToInPlay(this);
    }

    @Override
    public int getCost() {
        return 6;
    }

    @Override
    public String getName() {
        return "Gold";
    }

    @Override
    public String getDescription() {
        return "Worth 3 Coins";
    }
}
