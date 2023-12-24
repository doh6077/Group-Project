package WithdrawStrategy;

/**
*WithdrawStrategy interface implementable by other classes to customize methods for determining the excess of withdrawal limit
*and execute withdrawal activity*/

import BankAccount.BankAccount;

public interface WithdrawStrategy {
    /*Determine whether the amount to be withdrawn is over limit*/
    boolean isWithdrawLimit(double Amount);
    /*Carry out the withdrawal activity of certain valid amount based on a valid bank account*/
    void withdraw(BankAccount account, double amount)throws Exception;
}
