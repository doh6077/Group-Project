package BankAccount;
/**
*General Bank Account class with fundamental attributes and methods*/

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

    /*Get account number*/
    public String getAccountNumber() {
        return accountNumber;
    }

    /*Generate unique account number for each account sign-up*/
    public void generateAccountNumber(){
        this.accountNumber = AccountIDGenerator.generateAccountID();
    }

    /*Manually set account number*/
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /*Return the balance of a specific account*/
    public String getBalance() {
        return balance;
    }

    /*Set account balance*/
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /*Get types of transfer strategy of a specific account*/
    public TransferStrategy getTransferStrategy() {
        return transferStrategy;
    }

    /*Set types of transfer strategy for a specific account*/
    public void setTransferStrategy(TransferStrategy transferStrategy) {
        this.transferStrategy = transferStrategy;
    }

    /*Get types of withdrawal strategy of a specific account*/
    public WithdrawStrategy getWithdrawStrategy() {
        return withdrawStrategy;
    }
    
    /*Set types of withdrawal strategy for a specific account*/
    public void setWithdrawStrategy(WithdrawStrategy withdrawStrategy) {
        this.withdrawStrategy = withdrawStrategy;
    }

    /*Get types of deposit strategy of a specific account*/
    public DepositStrategy getDepositStrategy() {
        return depositStrategy;
    }

    /*Set types of deposit strategy for a specific account*/
    public void setDepositStrategy(DepositStrategy depositStrategy) {
        this.depositStrategy = depositStrategy;
    }

    /*Retrieve customer information of a certain bank account*/
    public Customer getCustomer() {
        return customer;
    }

    /*Set customer information for a certain bank account*/
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

     /**Transfer money from one bank account to another
     *@param BankAccount initialAccount: account to transfer from 
     *@param BankAccount targetAccount: account to transfer to
     *@param double amount: amount of money to be transferred between accounts
     *@return void*/
    public void transfer(BankAccount initialAccount, BankAccount targetAccount, double amount)throws Exception{
        this.setTransferStrategy(TransferStrategyFactory.getTransferStrategy(initialAccount));
        this.getTransferStrategy().transfer(initialAccount,targetAccount,amount);
    }

    /**Withdraw money from a bank account 
     *@param BankAccount account: account to withdraw money from 
     *@param double amount: amount of money to be withdrawn from account
     *@return void*/
    public void withdraw(BankAccount account, double amount) throws Exception{
        this.setWithdrawStrategy(WithdrawStrategyFactory.getWithdrawStrategy(account));
        this.getWithdrawStrategy().withdraw(account,amount);
    }

    /**Deposit money to a bank account 
     *@param BankAccount account: account to deposit money to 
     *@param double amount: the amount of money to be deposit to the account
     *@return void*/
    public void deposit(BankAccount account, double amount)throws Exception{
        this.setDepositStrategy(DepositStrategyFactory.getDepositStrategy(account));
        this.getDepositStrategy().deposit(account,amount);
    }

    /*Retrieve account type of a certain bank account*/
    public AccountType getAccountType() {
        return accountType;
    }

    /*set the type of a bank account*/
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /*Retrieve term for a certain account*/
    public String getTerm() {
        return term;
    }

    /*Set term for a certain account*/
    public void setTerm(String term) {
        this.term = term;
    }

}
