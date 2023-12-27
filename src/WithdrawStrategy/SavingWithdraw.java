package WithdrawStrategy;

import BankAccount.*;
import Enum.EarlyPenalty;
import Enum.WithdrawLimit;
import Exception.*;

/**
*Concrete withdrawal strategy class for Savings Account class implements the interface of WithdrawalStrategy
*Provide methods to assess if withdrawal from Savings Account is within the valid limit
*Provide concrete withdrawal method for Savings Account*/
public class SavingWithdraw implements WithdrawStrategy{
    public SavingWithdraw(){

    }
    
     /*Check if the amount entered by the user is over the withdrawal limit
    *@param double amount: amount to be withdrawn by the user
    *@return boolean: true if the transfer is within the withdrawal limit otherwise return false*/
    public boolean isWithdrawLimit(double amount){
        if(amount>WithdrawLimit.THREETHOUSAND.getValue()){
            return true;
        }else{
            return false;
        }
    }

     /*Withdrawal method for savings account to withdraw money from one account to another account with validation of 
    *appropriate numeric format and minimum and maximum balance requirements
    *@param BankAccount account: savings  account where money is withdrawn from
    *@param double amount: amount of money to withdraw
    *@return boolean: void
    *@throw exception: InvalidInputException, MinimumBalanceException, ExcessTransferException*/
    public void withdraw(BankAccount account, double amount)throws Exception{
        if(amount>Double.parseDouble(account.getBalance())){
            throw new MinimumBalanceException("Error: Cannot withdraw more than balance!");
        }else if(isWithdrawLimit(amount)){
            throw new ExcessTransferException("Error: Withdrawing amount exceeds daily limit!");
        }else if (!(account instanceof SavingAccount)){
            throw new InvalidInputException("Error: Choose the wrong transfer method!");
        }else{
            double newBalance = Double.parseDouble(account.getBalance())-amount;
            
            if(((SavingAccount)account).isEarly()){
                newBalance -=amount*EarlyPenalty.FIVEPERCENT.getValue();
            }
            account.setBalance(String.valueOf(newBalance));

        }
    }
}
