public class Card implements Comparable<Card> {

    private int value;
    private String face;
    private String suit;
    private String symbol;
    private static String[] faces = { " A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private static String[] suits = { " S", "C", "H", "D" };

    public Card(int n) {
        String[] symbols = { "\u2660", "\u2663", "\u2665", "\u2666" };

        value = n % 13 + 1;
        face = faces[n % 13];
        suit = suits[n / 13 % 4];
        symbol = symbols[n / 13 % 4];

        if (value > 10) {
            value = 10;
        } else if (value == 1) {
            value = 11;
        }
    }

    /**
     * The compareTo method should return a negative integer, zero, or a
     * positive integer if this Card is less than, equal to, or greater than
     * the other Card. The order of the cards should be 2, 3, 4, 5, 6, 7, 8, 9,
     * 10, J, Q, K, A. You should compare the cards values except when both
     * values are 10. You will then need to compare the cards faces when their
     * values are both 10. Here are some examples;
     */
    public int compareTo(Card other) {
        return value - other.value;
    }

    private String getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        String result = face + symbol;
        if (result.length() == 2) {
            result = " " + result;
        }

        if (suit.equals("H") || suit.equals("D")) {
            return "\u001B[31m" + result + "\u001B[0m";
        } else {
            return result;
        }
    }
}