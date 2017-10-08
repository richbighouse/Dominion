package game.player;

import com.google.common.collect.Lists;
import game.cards.Card;
import game.cards.base.Copper;
import game.cards.base.Estate;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
A Deck represents all the cards owned by a player. A player's cards can be in 1 of 4 states, 3 of which are represented
by the Deck object. The 4th state: inPlay, belongs to the Turn.

hand: Cards the player holds and are available to play
discard: Cards that have been discarded and cleaned up after being inPlay
drawDeck: Cards that are available to be drawn.

 */

public class Deck {

    private List<Card> hand = Lists.newArrayList();
    private Stack<Card> discard = new Stack<>();
    private Stack<Card> drawDeck = new Stack<>();

    public void initialize() {
        for(int i = 0; i < 3; i++) {
            drawDeck.push(new Estate());
        }
        for(int i = 0; i < 7; i++) {
            drawDeck.push(new Copper());
        }
        Collections.shuffle(drawDeck);
    }

    public void drawCards(int numberOfDraws) {
        while(numberOfDraws > 0 && hasCardToDraw()) {
            shuffleIfNeeded();
            hand.add(drawDeck.remove(0));
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
            shuffleIfNeeded();
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
        return drawDeck.size() + discard.size() > 0;
    }

    private void shuffleIfNeeded() {
        if(drawDeck.size() == 0) {
            drawDeck = (Stack<Card>)discard.clone();
            discard.clear();
            Collections.shuffle(drawDeck);
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public Stack<Card> getDiscard() {
        return discard;
    }

    public Stack<Card> getDrawDeck() {
        return drawDeck;
    }
}
