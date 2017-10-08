package game.cards.base;

import game.cards.VictoryCard;

public class Duchy extends VictoryCard {
    @Override
    public int getVictoryPoints() {
        return 3;
    }

    @Override
    public int getCost() {
        return 5;
    }

    @Override
    public String getName() {
        return "Duchy";
    }

    @Override
    public String getDescription() {
        return "Worth 3 VP";
    }
}
