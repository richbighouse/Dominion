package game.cards;

import game.controller.Turn;

public abstract class TreasureCard extends Card {

    @Override
    public void addCartType() {
        this.getCardTypes().add(CardType.TREASURE);
    }

    public abstract int getCoins();

    public abstract void play(Turn turn);

}
