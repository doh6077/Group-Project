package BankAccount;

/**
* Check Account type, subclass of BankAccount*/

import Customer.Customer;
import Enum.AccountType;


public class CheckAccount extends BankAccount{
    public CheckAccount(){

    }

    public CheckAccount(AccountType accountType, Customer customer){
        super(accountType,customer);
    }

}
