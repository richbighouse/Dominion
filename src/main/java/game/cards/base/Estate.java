package game.cards.base;

import game.cards.VictoryCard;

public class Estate extends VictoryCard {

    @Override
    public int getCost() {
        return 2;
    }

    @Override
    public String getName() {
        return "Estate";
    }

    @Override
    public String getDescription() {
        return "Worth 1 VP";
    }

    @Override
    public int getVictoryPoints() {
        return 1;
    }
}
