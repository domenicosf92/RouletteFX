package sample;

public class Main {
    public static void main(String[] args) {
        Game roulette = new Game(1000);
        Player player = new Player("Pippo", 100);
        Bet bet = new Bet();
        bet.addBet(50);
        System.out.println(roulette.betColor(player, bet, Game.Slot.RED));
        System.out.println(roulette);
        System.out.println(player);
    }
}
