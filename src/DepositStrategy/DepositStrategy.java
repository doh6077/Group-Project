package DepositStrategy;
import BankAccount.*;

/**
*DepositStrategy interface implementable by other classes to customize methods for executing transfer activity*/
public interface DepositStrategy {

     /*Carry out deposit transaction from the initial account to target account*/
    void deposit(BankAccount account, double amount)throws Exception;
}
