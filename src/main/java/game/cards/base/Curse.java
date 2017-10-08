package game.cards.base;

import game.cards.Card;

public class Curse extends Card {

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String getName() {
        return "Curse";
    }

    @Override
    public String getDescription() {
        return "Worth -1 VP";
    }
}
