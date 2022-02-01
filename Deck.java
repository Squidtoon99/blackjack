
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cardDeck;

    // abc
    public Deck() {
        cardDeck = new ArrayList<>();
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {

        for (int i = 0; i < 52; i++) {
            cardDeck.add(new Card(i));
        }
    }

    public Card dealCard() {
        if ((!cardDeck.isEmpty())) {
            return cardDeck.remove(0);
        } else {
            return null;
        }
    }

    public int getDeckSize() {
        return cardDeck.size();
    }

    public void shuffleDeck() {

        for (int i = 0; i < cardDeck.size(); i++) {
            int random = (int) (Math.random() * cardDeck.size());

            Card swap = cardDeck.get(i);
            cardDeck.set(i, cardDeck.get(random));
            cardDeck.set(random, swap);
        }
    }

    public void show() {

        for (int i = 0; i < cardDeck.size(); i++) {
            if (i != 0 && i % 13 == 0) {
                System.out.println();
            }
            System.out.print(cardDeck.get(i) + " ");
        }
        System.out.println();
    }
}
