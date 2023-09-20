package WithdrawStrategy;

import BankAccount.*;
import Enum.WithdrawLimit;
import Exception.*;

public class CheckWithdraw implements WithdrawStrategy{

    public CheckWithdraw(){

    }

    public boolean isWithdrawLimit(double amount){
        if(amount>WithdrawLimit.TWOTHOUSAND.getValue()){
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
        }else if (!(account instanceof CheckAccount)){
            throw new InvalidInputException("Error: Choose the wrong withdraw method!");
        }else{
            account.setBalance(String.valueOf(Double.parseDouble(account.getBalance())-amount));
        }
    }
}
