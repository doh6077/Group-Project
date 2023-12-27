package WithdrawStrategy;

import BankAccount.*;
import Enum.WithdrawLimit;
import Exception.*;

/**
*Concrete withdrawal strategy class for Checking Account class implements the interface of WithdrawalStrategy
*Provide methods to assess if withdrawal from checking account is within the valid limit
*Provide concrete withdrawal method for checking account*/
public class CheckWithdraw implements WithdrawStrategy{

    public CheckWithdraw(){

    }

    /*Check if the amount entered by user is over the withdrawal limit
    *@param double amount: amount to be withdrawn by user
    *@return boolean: true if the transfer is within withdrawal limit otherwise return false*/
    public boolean isWithdrawLimit(double amount){
        if(amount>WithdrawLimit.TWOTHOUSAND.getValue()){
            return true;
        }else{
            return false;
        }
    }

     /*Withdrawal method for checking account to withdraw money from one account to another account with validation of 
    *appropriate numeric format and minimum and maximum balance requirements
    *@param BankAccount account: account where money is withdrawn from
    *@param double amount: amount of money to withdraw
    *@return boolean: void
    *@throw exception: InvalidInputException, MinimumBalanceException, ExcessTransferException*/
    public void withdraw(BankAccount account, double amount)throws Exception{
        if(amount>Double.parseDouble(account.getBalance())){
            throw new MinimumBalanceException("Error: Cannot withdraw more than balance!");
        }else if(isWithdrawLimit(amount)){
            throw new ExcessTransferException("Error: Withdrawing amount exceeds daily limit!");
        }else if (!(account instanceof CheckAccount)){
            throw new InvalidInputException("Error: Choose the wrong withdraw method!");
        }else{
            account.setBalance(String.valueOf(Double.parseDouble(account.getBalance())-amount));
        }
    }
}
