package game.cards.base;

import game.cards.TreasureCard;
import game.cards.VictoryCard;

public class Province extends VictoryCard {
    @Override
    public int getVictoryPoints() {
        return 6;
    }

    @Override
    public int getCost() {
        return 8;
    }

    @Override
    public String getName() {
        return "Province";
    }

    @Override
    public String getDescription() {
        return "Worth 6 VP";
    }
}
