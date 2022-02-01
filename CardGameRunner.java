public class CardGameRunner {
    public static void main(String[] args) {
        int numberOfPlayers = 10;
        Game game = new Game(numberOfPlayers);
        game.playGame();
    }
}