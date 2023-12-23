package BankAccount;

/**
* Savings Account type, subclass of BankAccount*/

import Customer.Customer;
import Enum.AccountType;

public class SavingAccount extends BankAccount {
    private double interestRate;
    private boolean isEarly;

    public SavingAccount(){

    }
    
    public SavingAccount(AccountType accountType, Customer customer, String term){
        super(accountType, customer);
        this.term = term;
    }

    /*Retrieve interest rate of a savings account*/
    public double getInterestRate() {
        return interestRate;
    }

    /*Set interest rate of a savings account*/
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /*Check if the term of a savings account has elapsed or not*/
    public boolean isEarly() {
        return isEarly;
    }

    /*Determine whether the term of a savings account has matured*/
    public void setIsEarly(double term) {
        if(Double.parseDouble(this.term) > term){
            this.isEarly = true;
        }else{
            this.isEarly = false;
        }
    }


}
