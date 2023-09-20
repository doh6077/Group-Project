package WithdrawStrategy;

import BankAccount.BankAccount;

public interface WithdrawStrategy {
    boolean isWithdrawLimit(double Amount);
    void withdraw(BankAccount account, double amount)throws Exception;
}
