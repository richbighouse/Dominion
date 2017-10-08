package game.cards;

import game.controller.Turn;

//TODO implement dependency injection at one point
public class TreasureUtil {

    public static int getCoins(Card card) {
        if(card instanceof TreasureCard) {
            return ((TreasureCard) card).getCoins();
        }
        return 0;
    }

    public static void playTreasure(Card card, Turn turn) {
        if(card instanceof TreasureCard) {
            ((TreasureCard) card).playTreasure(turn);
        }
    }



}
