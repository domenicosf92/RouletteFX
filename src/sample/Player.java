package sample;

public class Player {
    private String name;
    private double credit;

    public Player(String name, double credit) {
        this.name = name;
        this.credit = credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public boolean removeCredit(double credit) {
        if (this.credit > credit) {
            this.credit -= credit;
            return true;
        }
        return false;
    }

    public void addCredit(double credit) {
        this.credit += credit;
    }

    public double getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        String s= "--Player--\n" + "Name: " + this.name + "\nCredit: " + this.credit;
        return s;
    }
}
