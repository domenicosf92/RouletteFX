package sample;

public class Main {
    public static void main(String[] args) {
        Game roulette = new Game(1000);
        Player player = new Player("Domenico", 500);
        Bet bet = new Bet();
        bet.addNumberAndBet(10, 50);
        System.out.println(roulette.betNumbers(player, bet));
        System.out.println(roulette);
        System.out.println(player);
    }
}
