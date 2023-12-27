package DepositStrategy;

import BankAccount.*;
import Exception.*;

/**
*Concrete deposit strategy class for Checking Account class implements the interface of DepositStrategy
*Provide methods to assess if the deposit on a checking account is within the valid limit
*Provide concrete deposit method for checking account*/
public class CheckDeposit implements DepositStrategy {
    public CheckDeposit(){

    }

    /*Check if the amount entered by user is in valid numeric format
    *@param String str: amount input by user
    *@return boolean: true if input is in valid numeric format otherwise return false*/
    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*Deposit method for checking account  
    *@param BankAccount account: account for money deposit
    *@param double amount: amount of money to deposit
    *@return boolean: void
    *@throw exception: InvalidInputException*/
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
