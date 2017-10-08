package game.cards.base;

import game.cards.Card;
import game.cards.CardType;

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

    @Override
    public void addCartType() {
        this.getCardTypes().add(CardType.CURSE);
    }
}
