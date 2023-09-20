package Customer;

import java.util.ArrayList;

import AccountLogin.UserAccount;
import BankAccount.BankAccount;

public class Customer {
    private String name;
    private String email;
    private String socialSecurityNumber;
    private UserAccount userAccount;
    private ArrayList<BankAccount> bankAccounts;

    public Customer(){

    }

    public Customer(BankAccount bankAccount, UserAccount userAccount){
        this.userAccount = userAccount;
        this.bankAccounts = new ArrayList();
        bankAccounts.add(bankAccount);
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    
}
