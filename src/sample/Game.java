package sample;

import java.util.Arrays;

public class Game {

    private int [] roulette = new int [37];
    private int [] red = new int[] {-1,1,-1,3,-1,5,-1,7,-1,9,-1,-1,12,-1,14,-1,16,-1,18,19,-1,21,-1,23,-1,25,-1,27,-1,-1,30,-1,32,-1,34,-1,36};
    private int [] black = new int[] {-1,-1,2,-1,4,-1,6,-1,8,-1,10,11,-1,13,-1,15,-1,17,-1,-1,20,-1,22,-1,24,-1,26,-1,28,29,-1,31,-1,33,-1,35,-1};
    private int passe [] = new int[18];
    private int manque [] = new int[18];
    private double credit;
    private int spinValue;
    private int manqueNumbers = 19;
    public enum Slot{
        GREEN,
        RED,
        BLACK,
        EVEN,
        ODD,
        PASSE,
        MANQUE
    }

    public Game(double credit) {
        this.credit = credit;
        for (int i = 0; i < this.roulette.length; i ++){
            this.roulette[i] = i;
        }
        for (int i = 0; i< this.passe.length; i ++){
            this.passe[i] = i+1;
        }
        for (int i = 0; i< this.manque.length; i ++){
            this.manque[i] = this.manqueNumbers;
            this.manqueNumbers ++;
        }
    }

    private int spin(){
        this.spinValue = (int) (Math.random() * 36);
        return this.spinValue;
    }

    public boolean betNumbers(Player player, Bet bet){
        for (int i=0; i< bet.numbers.size(); i++){
            if (player.getCredit()< bet.bets.get(i)) {
                return false;
            }
            player.removeCredit(bet.bets.get(i));
            this.credit += bet.bets.get(i);
            this.spin();
            if (this.spinValue == bet.numbers.get(i)){
                if (bet.numbers.size() ==1 ) {
                    this.credit -= bet.bets.get(i) + (bet.bets.get(i) * 35);
                    player.addCredit(bet.bets.get(i) + (bet.bets.get(i) * 35));
                } else if (bet.numbers.size() == 2){
                    this.credit -= bet.bets.get(i) + (bet.bets.get(i) * 17);
                    player.addCredit(bet.bets.get(i) + (bet.bets.get(i) * 17));
                } else if (bet.numbers.size() == 3){
                    this.credit -= bet.bets.get(i) + (bet.bets.get(i) * 11);
                    player.addCredit(bet.bets.get(i) + (bet.bets.get(i) * 11));
                } else if (bet.numbers.size() == 6){
                    this.credit -= bet.bets.get(i) + (bet.bets.get(i) * 5);
                    player.addCredit(bet.bets.get(i) + (bet.bets.get(i) * 5));
                } else if (bet.numbers.size() == 12){
                    this.credit -= bet.bets.get(i) + (bet.bets.get(i) * 2);
                    player.addCredit(bet.bets.get(i) + (bet.bets.get(i) * 2));
                }
                return true;
            }
        }
        return false;
    }

    public boolean betColor(Player player, Bet bet, Slot rouletteSlot){
        if (player.getCredit()< bet.bets.get(0)) {
            return false;
        }
        player.removeCredit(bet.bets.get(0));
        this.credit += bet.bets.get(0);
        this.spin();
        for (int i=0; i< this.red.length; i++) {
            if ((this.spinValue == this.red[i]) && (rouletteSlot == Slot.RED)){
                this.credit -= bet.bets.get(0) + bet.bets.get(0);
                player.addCredit(bet.bets.get(0) + bet.bets.get(0));
                return true;
            }
            if ((this.spinValue == this.black[i]) && (rouletteSlot == Slot.BLACK)){
                this.credit -= bet.bets.get(0) + bet.bets.get(0);
                player.addCredit(bet.bets.get(0) + bet.bets.get(0));
                return true;
            }
        }
        return false;
    }

    public boolean betPasseManque(Player player, Bet bet, Slot rouletteSlot){
        if (player.getCredit()< bet.bets.get(0)) {
            return false;
        }
        player.removeCredit(bet.bets.get(0));
        this.credit += bet.bets.get(0);
        this.spin();
        for (int i=0; i< this.passe.length; i++) {
            if (((this.spinValue == this.passe[i]) && (rouletteSlot == Slot.PASSE)) || ((this.spinValue == this.manque[i]) && (rouletteSlot == Slot.MANQUE))){
                this.credit -= bet.bets.get(0) + bet.bets.get(0);
                player.addCredit(bet.bets.get(0) + bet.bets.get(0));
                return true;
            }
        }
        return false;
    }

    public boolean betEvenOdd(Player player, Bet bet, Slot rouletteSlot){
        if (player.getCredit()< bet.bets.get(0)) {
            return false;
        }
        player.removeCredit(bet.bets.get(0));
        this.credit += bet.bets.get(0);
        this.spin();
        if ((((this.spinValue % 2) == 0) && (rouletteSlot == Slot.EVEN)) || (((this.spinValue % 2) != 0) && (rouletteSlot == Slot.ODD))) {
            this.credit -= bet.bets.get(0) + bet.bets.get(0);
            player.addCredit(bet.bets.get(0) + bet.bets.get(0));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Game roulette: \n");
        for (int i = 0; i < this.roulette.length; i++) {
            if (this.roulette[i] == this.red[i]) {
                s.append(this.roulette[i]).append(" |").append(Slot.RED).append("|\n");
            }
            else if (this.roulette[i] == this.black[i]){
                s.append(this.roulette[i]).append(" |").append(Slot.BLACK).append("|\n");
            } else {
                s.append(this.roulette[i]).append(" |").append(Slot.GREEN).append("|\n");
            }
        }

        s.append("Spin: ").append(this.spinValue);
        return s.toString();
    }
}
