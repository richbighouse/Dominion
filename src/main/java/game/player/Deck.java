package game.player;

import com.google.common.collect.Lists;
import game.cards.Card;
import game.cards.base.Copper;
import game.cards.base.Estate;

import java.util.Collections;
import java.util.List;

/*
A Deck represents all the cards owned by a player. A player's cards can be in 1 of 4 states, 3 of which are represented
by the Deck object. The 4th state: inPlay, belongs to the Turn.

hand: Cards the player holds and are available to play
discard: Cards that have been discarded and cleaned up after being inPlay
deck: Cards that are available to be drawn.

 */

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

    public void drawCards(int numberOfDraws) {
        while(numberOfDraws > 0 && hasCardToDraw()) {
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

    public void drawCardsUntil(int numberOfCardsInHand) {
        while(hand.size() < numberOfCardsInHand && hasCardToDraw()){
            validateDeckState();
            drawCards(1);
        }
    }

    public void drawNewHand() {
        this.drawCards(5);
    }

    public void cleanUpHand() {
        discard.addAll(hand);
        hand.clear();
    }

    private boolean hasCardToDraw() {
        return deck.size() + discard.size() > 0;
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
