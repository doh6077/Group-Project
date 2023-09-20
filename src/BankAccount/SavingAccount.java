package BankAccount;

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

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isEarly() {
        return isEarly;
    }

    public void setIsEarly(double term) {
        if(Double.parseDouble(this.term) > term){
            this.isEarly = true;
        }else{
            this.isEarly = false;
        }
    }


}
