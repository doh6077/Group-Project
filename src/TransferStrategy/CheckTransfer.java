package TransferStrategy;

import BankAccount.*;
import Enum.TransferLimit;
import Exception.*;

public class CheckTransfer implements TransferStrategy{
    public CheckTransfer(){

    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isTransferLimit(double amount){
        if(amount>TransferLimit.ONETHOUSAND.getValue()){
            return true;
        }else{
            return false;
        }
    }

    public void transfer(BankAccount initialAccount, BankAccount targetAccount, double amount) throws Exception{
        if (!(initialAccount instanceof CheckAccount)){ 
            throw new InvalidInputException("Error: Choose the wrong transfer method!");
        }else{
            if(!isNumeric(initialAccount.getBalance()) ){
               throw new MinimumBalanceException("Error: Cannot transfer more than balance!");    
            }else{
                if(amount>Double.parseDouble(initialAccount.getBalance())){
                    throw new MinimumBalanceException("Error: Cannot transfer more than balance!");
                }else if(isTransferLimit(amount)){
                    throw new ExcessTransferException("Error: Transferring amount exceeds daily limit!");
                }else{
                    double newBalanceInitial = Double.parseDouble(initialAccount.getBalance())-amount;
                    initialAccount.setBalance(String.valueOf(newBalanceInitial));

                    if(!isNumeric(targetAccount.getBalance())){
                        targetAccount.setBalance(String.valueOf(amount));
                    }else{
                        double newBalanceTarget = Double.parseDouble(targetAccount.getBalance()) + amount;
                        targetAccount.setBalance(String.valueOf(newBalanceTarget));
                    }
                }
            }
        
        }

        }
    }
