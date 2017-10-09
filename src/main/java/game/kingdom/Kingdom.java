package game.kingdom;

import com.google.common.collect.Lists;
import game.cards.Card;
import game.cards.base.*;

import java.util.List;

public class Kingdom {

    private static Kingdom instance = null;

    private int numPlayers = 2; //TODO probably get this from somewhere else
    private List<Card> trashPile = Lists.newArrayList();
    private List<Pile> defaultPiles = Lists.newArrayList();
    private List<Pile> kingdomPiles = Lists.newArrayList();

    private Kingdom() {
        initializeDefaultPiles();
    }

    public Kingdom getInstance() {
        if(instance == null) {
            instance = new Kingdom();
        }
        return instance;
    }

    private void initializeDefaultPiles(){
        int numVictoryCards = (numPlayers == 2) ? 8 : 12;

        defaultPiles.add(new StandardPile(new Copper(), 60));
        defaultPiles.add(new StandardPile(new Silver(), 40));
        defaultPiles.add(new StandardPile(new Gold(), 30));
        defaultPiles.add(new StandardPile(new Estate(), numVictoryCards));
        defaultPiles.add(new StandardPile(new Duchy(), numVictoryCards));
        defaultPiles.add(new StandardPile(new Province(), numVictoryCards));
        defaultPiles.add(new StandardPile(new Curse(), numPlayers * 10));
    }

    public int getNumberOfPlayers() {
        return numPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numPlayers = numberOfPlayers;
    }
}
