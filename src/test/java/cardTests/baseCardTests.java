package cardTests;

import game.cards.base.Festival;
import game.cards.base.Laboratory;
import game.cards.base.Smithy;
import game.cards.base.Village;
import game.controller.HumanTurn;
import game.controller.Turn;
import game.player.Deck;
import game.player.HumanPlayer;
import game.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class baseCardTests {

    private Turn turn;
    private Player player;
    private Deck deck;

    @Before
    public void setUp() {
        turn = new HumanTurn();
        player = new HumanPlayer();
        turn.setPlayer(player);
        deck = new Deck();
        turn.getPlayer().setDeck(deck);
        turn.getPlayerDeck().initialize();
        turn.getPlayerDeck().drawNewHand();
    }

    @Test
    public void smithy() {
        turn.getPlayerHand().add(new Smithy());
        assertThat(deck.getHand().size()).isEqualTo(6);
        assertThat(deck.getDrawDeck().size()).isEqualTo(5);
        turn.playAction(new Smithy());
        assertThat(deck.getHand().size()).isEqualTo(8);
        assertThat(deck.getDrawDeck().size()).isEqualTo(2);
        assertThat(turn.getInPlay().size()).isEqualTo(1);
        assertThat(turn.getActions()).isEqualTo(0);
    }

    @Test
    public void village() {
        turn.getPlayerHand().add(new Village());
        turn.playAction(new Village());
        assertThat(deck.getHand().size()).isEqualTo(6);
        assertThat(deck.getDrawDeck().size()).isEqualTo(4);
        assertThat(turn.getInPlay().size()).isEqualTo(1);
        assertThat(turn.getActions()).isEqualTo(2);
    }

    @Test
    public void laboratory() {
        turn.getPlayerHand().add(new Laboratory());
        turn.playAction(new Laboratory());
        assertThat(deck.getHand().size()).isEqualTo(7);
        assertThat(deck.getDrawDeck().size()).isEqualTo(3);
        assertThat(turn.getInPlay().size()).isEqualTo(1);
        assertThat(turn.getActions()).isEqualTo(1);
    }

    @Test
    public void festival() {
        turn.getPlayerHand().add(new Festival());
        turn.playAction(new Festival());
        assertThat(deck.getHand().size()).isEqualTo(5);
        assertThat(deck.getDrawDeck().size()).isEqualTo(5);
        assertThat(turn.getInPlay().size()).isEqualTo(1);
        assertThat(turn.getActions()).isEqualTo(2);
        assertThat(turn.getBuys()).isEqualTo(2);
        assertThat(turn.getCoins()).isEqualTo(2);
    }


}
