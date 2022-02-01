public class Game {

    private Deck deck;
    private Player[] players;

    public Game(int numPlayers) {
        deck = new Deck();
        players = new Player[numPlayers];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
    }

    /**
     * Game class:
     * The following should take place in the playGame method or in a helper method.
     * 1. Deal two cards to every player.
     * 2. Loop through all the players and deal additional cards until their hit
     * method returns false.
     * 3. Print out the dealer
     * 4. Loop through the other players and see if they win or lose against the
     * dealer based on the rules. Output the results like the examples below.
     */
    public void playGame() {

        for (Player player : players) {
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
        }

        Player dealer = players[0];
        for (Player player : players) {
            while (player.hit(dealer.getFaceUpCard())) {
                player.addCard(deck.dealCard());
            }
        }

        System.out.printf("%-6s %s\n", "", dealer);

        for (Player player : players) {
            if (player.equals(dealer)) {
                continue;
            }
            String result = switch (Integer.compare(player.getScoreValue(), dealer.getScoreValue())) {
                case -1 -> "Loser";
                case 0 -> "Tie";
                case 1 -> "Winner";
                default -> throw new IllegalArgumentException(("Did not expect value from compare"));
            };

            System.out.printf("%-6s %s\n", result, player);
        }
    }

}