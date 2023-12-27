package DepositStrategy;
import BankAccount.*;
import Enum.MiniDeposit;
import Exception.*;

/**
*Concrete deposit strategy class for Savings Account class implements the interface of DepositStrategy
*Provide methods to assess if the deposit on a Savings Account is within the valid limit
*Provide concrete deposit method for Savings Account*/
public class SavingDeposit implements DepositStrategy{
    public SavingDeposit(){

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

    /*Deposit method for savings account  
    *@param BankAccount account: account for money deposit
    *@param double amount: amount of money to deposit
    *@return boolean: void
    *@throw exception: InvalidInputException, SavingThresholdException*/
    public void deposit(BankAccount account, double amount)throws Exception{
        System.out.println("saving deposit function get called");
        if (!(account instanceof SavingAccount)){
            throw new InvalidInputException("Error: Choose the wrong deposit method!");
            
        }else if(amount<MiniDeposit.TWOTHOUSAND.getValue()){

            throw new SavingThresholdException("Error: Do not qualify for minimum saving threshold!");
        
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
