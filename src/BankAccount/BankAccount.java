package BankAccount;

import TransferStrategy.*;
import WithdrawStrategy.*;
import DepositStrategy.*;
import Enum.AccountType;
import StrategyFactory.*;
import Customer.*;

public abstract class BankAccount {
    protected AccountType accountType;
    protected String accountNumber;
    protected String balance;
    protected String term;
    protected TransferStrategy transferStrategy;
    protected WithdrawStrategy withdrawStrategy;
    protected DepositStrategy depositStrategy;
    protected Customer customer;

    public BankAccount(){

    }

    public BankAccount(AccountType accountType, Customer customer) {
        generateAccountNumber();
        this.accountType = accountType;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void generateAccountNumber(){
        this.accountNumber = AccountIDGenerator.generateAccountID();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public TransferStrategy getTransferStrategy() {
        return transferStrategy;
    }

    public void setTransferStrategy(TransferStrategy transferStrategy) {
        this.transferStrategy = transferStrategy;
    }

    public WithdrawStrategy getWithdrawStrategy() {
        return withdrawStrategy;
    }

    public void setWithdrawStrategy(WithdrawStrategy withdrawStrategy) {
        this.withdrawStrategy = withdrawStrategy;
    }

    public DepositStrategy getDepositStrategy() {
        return depositStrategy;
    }

    public void setDepositStrategy(DepositStrategy depositStrategy) {
        this.depositStrategy = depositStrategy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void transfer(BankAccount initialAccount, BankAccount targetAccount, double amount)throws Exception{
        this.setTransferStrategy(TransferStrategyFactory.getTransferStrategy(initialAccount));
        this.getTransferStrategy().transfer(initialAccount,targetAccount,amount);
    }
    public void withdraw(BankAccount account, double amount) throws Exception{
        this.setWithdrawStrategy(WithdrawStrategyFactory.getWithdrawStrategy(account));
        this.getWithdrawStrategy().withdraw(account,amount);
    }
    public void deposit(BankAccount account, double amount)throws Exception{
        this.setDepositStrategy(DepositStrategyFactory.getDepositStrategy(account));
        this.getDepositStrategy().deposit(account,amount);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

}
