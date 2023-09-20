package TransferStrategy;

import BankAccount.BankAccount;

public interface TransferStrategy {
    boolean isTransferLimit(double amount);
    void transfer(BankAccount initialAccount, BankAccount targetAccount,double amount)throws Exception;
}
