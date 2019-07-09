package sample;

import java.util.ArrayList;

public class Bet {
    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<Integer> bets = new ArrayList<>();

    public void addNumberAndBet (int number, int bet) {
        this.numbers.add(number);
        this.bets.add(bet);
    }

    public void addBet (int bet){
        this.bets.add(bet);
    }
}
