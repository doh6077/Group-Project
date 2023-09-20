package DepositStrategy;
import BankAccount.*;
import Enum.MiniDeposit;
import Exception.*;

public class SavingDeposit implements DepositStrategy{
    public SavingDeposit(){

    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void deposit(BankAccount account, double amount)throws Exception{
        System.out.println("saving deposit function get called");
        if (!(account instanceof SavingAccount)){
            throw new InvalidInputException("Error: Choose the wrong deposit method!");
            
        }else if(amount<MiniDeposit.TWOTHOUSAND.getValue()){

            throw new SavingThresholdException("Error: Do not qualify for minimum saving threshold!");
        
        }else{

            if(!isNumeric(account.getBalance()) ){

                account.setBalance(String.valueOf(amount));

            }else{

                double currentBalance = Double.parseDouble(account.getBalance());

                account.setBalance(String.valueOf(currentBalance + amount));

            }
        }
    }
}
