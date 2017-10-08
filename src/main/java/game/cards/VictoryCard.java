package game.cards;

public abstract class VictoryCard extends Card {

    @Override
    public void addCartType() {
        this.getCardTypes().add(CardType.VICTORY);
    }

    public abstract int getVictoryPoints();

}
