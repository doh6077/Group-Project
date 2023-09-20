package DepositStrategy;
import BankAccount.*;
public interface DepositStrategy {
    void deposit(BankAccount account, double amount)throws Exception;
}
