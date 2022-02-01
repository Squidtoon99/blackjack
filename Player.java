import java.util.ArrayList;

public class Player {

    private static int totalPlayers = 0;
    private int playerNum, handValue;
    private ArrayList<Card> hand;
    private Card faceUpCard;

    public Player() {
        playerNum = totalPlayers++;
        handValue = 0;
        hand = new ArrayList<>();
    }

    public void addCard(Card c) {
        if (hand.size() == 0) {
            faceUpCard = c;
            hand.add(c);
        } else {
            int index = hand.size() - 1;

            while (index >= 0 && hand.get(index).compareTo(c) > 0) {
                index--;
            }

            hand.add(index + 1, c);
        }
        handValue += c.getValue();

        if (handValue > 21) {
            for (Card card : hand) {
                if (card.getValue() == 11) {
                    card.setValue(1);
                    handValue -= 10;
                    break;
                }
            }
        }
    }

    public boolean hit(Card dealerFaceUpCard) {
        return handValue < 17 || (handValue == 17 && faceUpCard.getValue() < dealerFaceUpCard.getValue());
    }

    public int getHandValue() {
        return handValue;
    }

    public boolean hasBlackJack() {
        return hand.size() == 2 && handValue == 21;
    }

    public int getScoreValue() {
        if (handValue > 21) {
            return -1;
        } else {
            if (hasBlackJack()) {
                return handValue + 1;
            }
            return handValue;
        }
    }

    public Card getFaceUpCard() {
        return faceUpCard;
    }

    public String toString() {
        if (playerNum == 0) {
            return "Dealer  : " + handValue + " " + hand;
        } else {
            return "Player " + playerNum + ": " + handValue + " " + hand;
        }
    }
}