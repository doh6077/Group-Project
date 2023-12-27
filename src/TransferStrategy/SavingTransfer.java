package TransferStrategy;

import BankAccount.*;
import Enum.EarlyPenalty;
import Enum.TransferLimit;
import Exception.*;

/**
*Concrete transfer strategy class for Savings Account class implements the interface of TransferStrategy
*Provide methods to assess if transfer for Savings Account is within the valid limit
*Provide concrete transfer method for Savings Account*/
public class SavingTransfer implements TransferStrategy{
    public SavingTransfer(){

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

    /*Check if the amount entered by user is over the transfer limit
    *@param double amount: amount to be transferred by user
    *@return boolean: true if the transfer is within transfer limit otherwise return false*/
    public boolean isTransferLimit(double amount){
        if(amount>TransferLimit.TWOTHOUSAND.getValue()){
            return true;
        }else{
            return false;
        }
    }

    /*Transfer method for savings account to transfer money from one account to another account with validation of 
    *appropriate numeric format and minimum and maximum balance requirements
    *@param BankAccount initialAccount: savings account where money transferred from
    *@param BankAccount targetAccount: account where money transfers to
    *@param double amount: amount of money to transfer
    *@return boolean: void
    *@throw exception: InvalidInputException, MinimumBalanceException, ExcessTransferException*/
    public void transfer(BankAccount initialAccount, BankAccount targetAccount, double amount) throws Exception{
        if (!(initialAccount instanceof SavingAccount)){ 
            throw new InvalidInputException("Error: Choose the wrong transfer method!");
        }else{
            if(!isNumeric(initialAccount.getBalance()) ){
               throw new MinimumBalanceException("Error: Cannot transfer more than balance!");    
            }else{
                if(amount>Double.parseDouble(initialAccount.getBalance())){
                    throw new MinimumBalanceException("Error: Cannot transfer more than balance!");
                }else if(isTransferLimit(amount)){
                    throw new ExcessTransferException("Error: Transferring amount exceeds daily limit!");
                }else if(targetAccount instanceof SavingAccount){
                    throw new SavingTransferLimitException("Error: Saving account can only transfer to check account!");
                }else{
                    double newBalanceInitial = Double.parseDouble(initialAccount.getBalance())-amount;
                    initialAccount.setBalance(String.valueOf(newBalanceInitial));

                    if(!isNumeric(targetAccount.getBalance())){
                        targetAccount.setBalance(String.valueOf(amount));
                    }else{
                        double newBalanceTarget = Double.parseDouble(targetAccount.getBalance()) + amount;
                        targetAccount.setBalance(String.valueOf(newBalanceTarget));
                    }
                    
                }
            }
        }
    }

}
