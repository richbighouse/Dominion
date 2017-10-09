package game.kingdom;

import game.cards.Card;

public abstract class Pile {

    private int count;

    public abstract Card pop();
    public abstract boolean isEmpty();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
