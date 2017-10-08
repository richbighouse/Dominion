package game.cards;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class Card {

    private List<CardType> cardTypes;

    public Card() {
        this.cardTypes = Lists.newArrayList();
    }

    public abstract int getCost();
    public abstract String getName();
    public abstract String getDescription();

    public List<CardType> getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(List<CardType> cardTypes) {
        this.cardTypes = cardTypes;
    }

    public abstract void addCartType();

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        Card card = (Card) obj;

        return this.getName().equals(card.getName());
    }
}
