package game.player;

import com.google.common.collect.Lists;
import game.cards.Card;
import game.cards.base.Copper;
import game.cards.base.Estate;

import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> hand = Lists.newArrayList();
    private List<Card> discard = Lists.newArrayList();
    private List<Card> deck = Lists.newArrayList();

    public void initialize() {
        for(int i = 0; i < 3; i++) {
            deck.add(new Estate());
        }
        for(int i = 0; i < 7; i++) {
            deck.add(new Copper());
        }
        Collections.shuffle(deck);
    }

    public void drawFromDeckToHand(int numberOfDraws) {
        while(numberOfDraws > 0 && deck.size() + discard.size() > 0) {
            validateDeckState();
            hand.add(deck.remove(0));
            numberOfDraws--;
        }
    }

    public void discardFromHandToDiscard(Card card) {
        if(hand.contains(card)) {
            discard.add(card);
            hand.remove(card);
        }
    }

    private void validateDeckState() {
        if(deck.size() == 0) {
            deck = Lists.newArrayList(discard);
            discard.clear();
            Collections.shuffle(deck);
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Card> getDiscard() {
        return discard;
    }

    public List<Card> getDeck() {
        return deck;
    }
}
