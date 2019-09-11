package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    Game roulette = new Game(1000);
    Player player = new Player("Domenico", 500);
    Bet bet = new Bet();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bet10;

    @FXML
    private Button bet25;

    @FXML
    private Button bet50;

    @FXML
    private Button bet100;

    @FXML
    private TextField extract;

    @FXML
    private TextField winOrLose;

    @FXML
    void BetOnBlack(ActionEvent event) {
        roulette.betColor(player,bet, Game.Slot.BLACK);
    }

    @FXML
    void BetOnRed(ActionEvent event) {
        boolean result = roulette.betColor(player,bet, Game.Slot.RED);
        this.extract.setText(String.valueOf(roulette.getSpinValue()));
        if (result) {
            this.winOrLose.setText("Win");
        } else {
            this.winOrLose.setText("Lose");
        }
    }

    @FXML
    void add0(ActionEvent event) {
        if (bet.bets.size()> bet.numbers.size()) {
            //bet.addNumberAndBet(0, );
        }
    }

    @FXML
    void add1(ActionEvent event) {

    }

    @FXML
    void add10(ActionEvent event) {

    }

    @FXML
    void add11(ActionEvent event) {

    }

    @FXML
    void add12(ActionEvent event) {

    }

    @FXML
    void add13(ActionEvent event) {

    }

    @FXML
    void add14(ActionEvent event) {

    }

    @FXML
    void add15(ActionEvent event) {

    }

    @FXML
    void add16(ActionEvent event) {

    }

    @FXML
    void add17(ActionEvent event) {

    }

    @FXML
    void add18(ActionEvent event) {

    }

    @FXML
    void add19(ActionEvent event) {

    }

    @FXML
    void add2(ActionEvent event) {

    }

    @FXML
    void add20(ActionEvent event) {

    }

    @FXML
    void add21(ActionEvent event) {

    }

    @FXML
    void add22(ActionEvent event) {

    }

    @FXML
    void add23(ActionEvent event) {

    }

    @FXML
    void add24(ActionEvent event) {

    }

    @FXML
    void add25(ActionEvent event) {

    }

    @FXML
    void add26(ActionEvent event) {

    }

    @FXML
    void add27(ActionEvent event) {

    }

    @FXML
    void add28(ActionEvent event) {

    }

    @FXML
    void add29(ActionEvent event) {

    }

    @FXML
    void add3(ActionEvent event) {

    }

    @FXML
    void add30(ActionEvent event) {

    }

    @FXML
    void add31(ActionEvent event) {

    }

    @FXML
    void add32(ActionEvent event) {

    }

    @FXML
    void add33(ActionEvent event) {

    }

    @FXML
    void add34(ActionEvent event) {

    }

    @FXML
    void add35(ActionEvent event) {

    }

    @FXML
    void add36(ActionEvent event) {

    }

    @FXML
    void add4(ActionEvent event) {

    }

    @FXML
    void add5(ActionEvent event) {

    }

    @FXML
    void add6(ActionEvent event) {

    }

    @FXML
    void add7(ActionEvent event) {

    }

    @FXML
    void add8(ActionEvent event) {

    }

    @FXML
    void add9(ActionEvent event) {

    }

    @FXML
    void bet10(ActionEvent event) {
        bet.addBet(10);
    }

    @FXML
    void bet100(ActionEvent event) {
        bet.addBet(100);
    }

    @FXML
    void bet25(ActionEvent event) {
        bet.addBet(25);
    }

    @FXML
    void bet50(ActionEvent event) {
        bet.addBet(50);
    }

    @FXML
    void betOnEven(ActionEvent event) {
        roulette.betEvenOdd(player,bet, Game.Slot.EVEN);
    }

    @FXML
    void betOnManque(ActionEvent event) {
        roulette.betPasseManque(player,bet, Game.Slot.MANQUE);
    }

    @FXML
    void betOnNumber(ActionEvent event) {
        roulette.betNumbers(player,bet);
    }

    @FXML
    void betOnOdd(ActionEvent event) {
        roulette.betEvenOdd(player,bet, Game.Slot.ODD);
    }

    @FXML
    void betOnPasse(ActionEvent event) {
        roulette.betPasseManque(player,bet, Game.Slot.PASSE);
    }

    @FXML
    void initialize() {
        assert extract != null : "fx:id=\"extract\" was not injected: check your FXML file 'Roulette.fxml'.";
        assert winOrLose != null : "fx:id=\"winOrLose\" was not injected: check your FXML file 'Roulette.fxml'.";

    }
}
