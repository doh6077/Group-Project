package WithdrawStrategy;

import BankAccount.*;
import Enum.EarlyPenalty;
import Enum.WithdrawLimit;
import Exception.*;

public class SavingWithdraw implements WithdrawStrategy{
    public SavingWithdraw(){

    }

    public boolean isWithdrawLimit(double amount){
        if(amount>WithdrawLimit.THREETHOUSAND.getValue()){
            return true;
        }else{
            return false;
        }
    }
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
