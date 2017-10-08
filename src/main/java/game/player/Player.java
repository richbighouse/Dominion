package game.player;

public abstract class Player {

    private String name;
    private Deck deck;

    public Player() {
        this.deck = new Deck();
    }

    public String getName() {
        return name;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
