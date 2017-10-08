package game.controller;

import com.google.common.collect.Lists;
import game.cards.ActionUtil;
import game.cards.Card;
import game.cards.TreasureCard;
import game.cards.TreasureUtil;
import game.player.Deck;
import game.player.Player;

import java.util.List;

public abstract class Turn {

    private int coins;
    private int buys;
    private int actions;
    private List<Card> inPlay;
    private Player player;

    Turn() {
        this.coins = 0;
        this.buys = 1;
        this.actions = 1;
        inPlay = Lists.newArrayList();
    }

    public void playAction(Card card) {
        if(actions > 0 && getPlayerHand().contains(card)) {
            actions--;
            ActionUtil.playAction(card, this);
        }

    }

    public void playAllTreasures() {
        for(Card card : Lists.newArrayList(getPlayerHand())) {
            if(card.isTreasure()) {
                TreasureUtil.playTreasure(card, this);
            }
        }
    }

    public void moveFromHandToInPlay(Card card) {
        getPlayerHand().remove(card);
        inPlay.add(card);
    }

    public void endTurnSequence() {
        cleanUpInPlay();
        drawNewHandAfterTurn();
    }

    private void cleanUpInPlay() {
        getPlayerDiscard().addAll(inPlay);
        inPlay.clear();
    }

    private void drawNewHandAfterTurn() {
        getPlayerDeck().drawCardsUntil(5);
    }

    public Deck getPlayerDeck() {
        return player.getDeck();
    }

    public List<Card> getPlayerDiscard() {
        return player.getDeck().getDiscard();
    }

    public List<Card> getPlayerDrawDeck() {
        return player.getDeck().getDrawDeck();
    }

    public List<Card> getPlayerHand() {
        return player.getDeck().getHand();
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void addBuys(int buys) {
        this.buys += buys;
    }

    public void addActions(int actions) {
        this.actions += actions;
    }

    public void useCoins(int coins) {
        this.coins -= coins;
    }

    public void useBuy() {
        this.buys--;
    }

    public void useAction() {
        this.actions--;
    }

    public int getCoins() {
        return coins;
    }

    public int getBuys() {
        return buys;
    }

    public int getActions() {
        return actions;
    }

    public List<Card> getInPlay() {
        return inPlay;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
