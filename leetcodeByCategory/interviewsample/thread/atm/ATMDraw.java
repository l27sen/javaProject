package leetcodeByCategory.interviewsample.thread.atm;

/**
 * Use ATM to draw money from account.
 */
public class ATMDraw {


    public static void main(String[] a) throws InterruptedException{
        Account account = new Account();
        account.setBalance(100);

        ATM atm = new ATM(account,40);
        new Thread(atm).start();
        new Thread(atm).start();
        Thread.sleep(2000);
        System.out.println(account.getBalance());
    }
}
