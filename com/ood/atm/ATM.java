package com.ood.atm;

public class ATM {


    String state;

    Account account;

    Card card;

    public double readInsertCard(){
        return 0;
    }

    public boolean authenticate(int pin){
        return true;
    }

    public void selectionTransaction(){


    }

    public double deposit_cash(){
        return 0d;
    }

    public void invalid_cash_returned(){

    }

    public String enter_withdrawal_amount(){
        return "";
    }

    public double display_balance(){
        return 0d;
    }

    public void execute_transaction(){

    }
    public String returnCard(){
        return "";
    }
}
