package game.kingdom;

/*
This class exist because some piles are standard and can't use this logic. Knights, for example.
*/

import game.cards.Card;

public class StandardPile extends Pile {

    private Card card;

    public StandardPile(Card card, int count) {
        this.card = card;
        this.setCount(count);
    }

    @Override
    public Card pop() {
        if(getCount() > 0) {
            return card;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return getCount() == 0;
    }

}
