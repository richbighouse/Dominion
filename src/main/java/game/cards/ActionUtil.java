package game.cards;

import game.controller.Turn;

//TODO implement dependency injection at one point
public class ActionUtil {

    public static void playAction(Card card, Turn turn) {
        if(card instanceof ActionCard) {
            ((ActionCard) card).playAction(turn);
        } else if (card instanceof ActionAttackCard) {
            ((ActionAttackCard) card).playAction(turn);
        }
    }



}
