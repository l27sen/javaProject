package interviewsample.thread.atm;

public class ATM implements Runnable {
    private double drawMoney;
    private Account account;

    public ATM(Account account, double drawMoney) {
        this.account = account;
        this.drawMoney = drawMoney;
    }

    public void run() {
        account.draw(drawMoney);
    }
}
