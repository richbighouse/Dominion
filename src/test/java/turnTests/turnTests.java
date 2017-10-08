package turnTests;

import game.cards.base.Copper;
import game.cards.base.Estate;
import game.cards.base.Gold;
import game.cards.base.Silver;
import game.controller.HumanTurn;
import game.controller.Turn;
import game.player.HumanPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class turnTests {

    private Turn turn;

    @Before
    public void setUp() {
        turn = new HumanTurn();
        turn.setPlayer(new HumanPlayer());
    }

    @Test
    public void endTurnSequence() {
        turn.getInPlay().add(new Copper());
        turn.getInPlay().add(new Copper());
        turn.getInPlay().add(new Estate());
        turn.getPlayerDrawDeck().add(new Copper());
        turn.getPlayerDrawDeck().add(new Copper());
        turn.getPlayerDrawDeck().add(new Copper());

        assertThat(turn.getInPlay().size()).isEqualTo(3);
        assertThat(turn.getPlayerDiscard().size()).isEqualTo(0);
        assertThat(turn.getPlayerDrawDeck().size()).isEqualTo(3);
        assertThat(turn.getPlayerHand().size()).isEqualTo(0);

        turn.endTurnSequence();
        assertThat(turn.getInPlay().size()).isEqualTo(0);
        assertThat(turn.getPlayerDiscard().size()).isEqualTo(0);
        assertThat(turn.getPlayerDrawDeck().size()).isEqualTo(1);
        assertThat(turn.getPlayerHand().size()).isEqualTo(5);
    }

    @Test
    public void moveFromHandToInPlay() {
        turn.getPlayerHand().add(new Copper());
        turn.getPlayerHand().add(new Copper());
        assertThat(turn.getInPlay().size()).isEqualTo(0);
        assertThat(turn.getPlayerHand().size()).isEqualTo(2);

        turn.moveFromHandToInPlay(new Copper());
        assertThat(turn.getInPlay().size()).isEqualTo(1);
        assertThat(turn.getPlayerHand().size()).isEqualTo(1);
    }

    @Test
    public void playAllTreasures() {
        turn.getPlayerHand().add(new Copper());
        turn.getPlayerHand().add(new Silver());
        turn.getPlayerHand().add(new Gold());
        assertThat(turn.getPlayerHand().size()).isEqualTo(3);
        assertThat(turn.getInPlay().size()).isEqualTo(0);
        assertThat(turn.getCoins()).isEqualTo(0);

        turn.playAllTreasures();
        assertThat(turn.getPlayerHand().size()).isEqualTo(0);
        assertThat(turn.getInPlay().size()).isEqualTo(3);
        assertThat(turn.getCoins()).isEqualTo(6);


    }


}
