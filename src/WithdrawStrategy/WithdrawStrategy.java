package WithdrawStrategy;

/**
*WithdrawStrategy interface implementable by other classes to customize methods for determining the excess of withdrawal limit
*and execute withdrawal activity*/

import BankAccount.BankAccount;

public interface WithdrawStrategy {
    boolean isWithdrawLimit(double Amount);
    void withdraw(BankAccount account, double amount)throws Exception;
}
