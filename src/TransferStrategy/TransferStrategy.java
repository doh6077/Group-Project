package TransferStrategy;

/**
*TransferStrategy interface implementable by other classes to customize methods for determining the excess of transfer limit
*and execute transfer activity*/

import BankAccount.BankAccount;

public interface TransferStrategy {
    /*Determine whether the amount to be transferred is over limit*/
    boolean isTransferLimit(double amount);
    
    /*Carry out transfer transaction from the initial account to target account*/
    void transfer(BankAccount initialAccount, BankAccount targetAccount,double amount)throws Exception;
}
