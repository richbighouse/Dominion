package game.cards;

public abstract class Card {

    public abstract int getCost();
    public abstract String getName();
    public abstract String getDescription();

    public boolean isTreasure() {
        if(this instanceof TreasureCard) {
            return true;
        }
        return false;
    }

    public boolean isVictory() {
        if(this instanceof VictoryCard) {
            return true;
        }
        return false;
    }

    public boolean isAction() {
        if(this instanceof ActionCard) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        Card card = (Card) obj;

        return this.getName().equals(card.getName());
    }
}
