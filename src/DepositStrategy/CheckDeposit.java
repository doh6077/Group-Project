package DepositStrategy;

import BankAccount.*;
import Exception.*;

public class CheckDeposit implements DepositStrategy {
    public CheckDeposit(){

    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void deposit(BankAccount account, double amount)throws Exception{

        if (!(account instanceof CheckAccount)){ 
            throw new InvalidInputException("Error: Choose the wrong deposit method!");
        }else{
            if(!isNumeric(account.getBalance()) ){
                account.setBalance(String.valueOf(amount));
                
            }else{
                double currentBalance = Double.parseDouble(account.getBalance());
                account.setBalance(String.valueOf(currentBalance + amount));
            }
            
        }
    }
}
