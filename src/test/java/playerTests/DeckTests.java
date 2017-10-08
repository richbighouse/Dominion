package playerTests;

import game.cards.Card;
import game.cards.base.Copper;
import game.cards.base.Estate;
import game.cards.base.Silver;
import game.player.Deck;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeckTests {

    Deck deck;

    @Test
    public void testInitialize() {
        deck = new Deck();
        assertThat(deck.getDeck().size()).isEqualTo(0);
        assertThat(deck.getHand().size()).isEqualTo(0);
        assertThat(deck.getDiscard().size()).isEqualTo(0);

        deck.initialize();
        assertThat(deck.getDeck().size()).isEqualTo(10);

        int coppers = 0;
        int estates = 0;
        for(Card card : deck.getDeck()) {
            if(card instanceof Estate){
                estates++;
            } else if (card instanceof Copper) {
                coppers++;
            }
        }
        assertThat(coppers).isEqualTo(7);
        assertThat(estates).isEqualTo(3);
    }

    @Test
    public void testDrawFromDeckToHand() {
        deck = new Deck();
        deck.initialize();

        deck.drawFromDeckToHand(1);
        assertThat(deck.getDeck().size()).isEqualTo(9);
        assertThat(deck.getHand().size()).isEqualTo(1);
        deck.drawFromDeckToHand(2);
        assertThat(deck.getDeck().size()).isEqualTo(7);
        assertThat(deck.getHand().size()).isEqualTo(3);
        deck.drawFromDeckToHand(3);
        assertThat(deck.getDeck().size()).isEqualTo(4);
        assertThat(deck.getHand().size()).isEqualTo(6);
        deck.drawFromDeckToHand(5);
        assertThat(deck.getDeck().size()).isEqualTo(0);
        assertThat(deck.getHand().size()).isEqualTo(10);
    }

    @Test
    public void testDiscardFromHandToDiscard() {
        deck = new Deck();
        deck.getHand().add(new Copper());
        deck.getHand().add(new Estate());

        deck.discardFromHandToDiscard(new Copper());
        assertThat(deck.getHand().size()).isEqualTo(1);
        assertThat(deck.getDiscard().size()).isEqualTo(1);

        deck.discardFromHandToDiscard(new Estate());
        assertThat(deck.getHand().size()).isEqualTo(0);
        assertThat(deck.getDiscard().size()).isEqualTo(2);

        deck.discardFromHandToDiscard(new Silver());
        assertThat(deck.getHand().size()).isEqualTo(0);
        assertThat(deck.getDiscard().size()).isEqualTo(2);
    }
}
