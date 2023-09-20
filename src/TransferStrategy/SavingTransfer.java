package TransferStrategy;

import BankAccount.*;
import Enum.EarlyPenalty;
import Enum.TransferLimit;
import Exception.*;

public class SavingTransfer implements TransferStrategy{
    public SavingTransfer(){

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
        if(amount>TransferLimit.TWOTHOUSAND.getValue()){
            return true;
        }else{
            return false;
        }
    }

    public void transfer(BankAccount initialAccount, BankAccount targetAccount, double amount) throws Exception{
        /*if(amount>Double.parseDouble(initialAccount.getBalance())){
            throw new MinimumBalanceException("Error: Cannot transfer more than balance!");
        }else if(isTransferLimit(amount)){
            throw new ExcessTransferException("Error: Transferring amount exceeds daily limit!");
        }else if (!(initialAccount instanceof SavingAccount)){
            throw new InvalidInputException("Error: Choose the wrong transfer method!");
        }else if(!(targetAccount instanceof SavingAccount)){
            throw new InvalidInputException("Error: Saving account is only allowed to transfer to check account!");
        }else{
            double newBalanceInitial = Double.parseDouble(initialAccount.getBalance())-amount;
            
            if(((SavingAccount)initialAccount).isEarly()){
                newBalanceInitial -=amount*EarlyPenalty.FIVEPERCENT.getValue();
            }
            initialAccount.setBalance(String.valueOf(newBalanceInitial));

            double newBalanceTarget = Double.parseDouble(targetAccount.getBalance()) + amount;
            targetAccount.setBalance(String.valueOf(newBalanceTarget));
        }*/
        if (!(initialAccount instanceof SavingAccount)){ 
            throw new InvalidInputException("Error: Choose the wrong transfer method!");
        }else{
            if(!isNumeric(initialAccount.getBalance()) ){
               throw new MinimumBalanceException("Error: Cannot transfer more than balance!");    
            }else{
                if(amount>Double.parseDouble(initialAccount.getBalance())){
                    throw new MinimumBalanceException("Error: Cannot transfer more than balance!");
                }else if(isTransferLimit(amount)){
                    throw new ExcessTransferException("Error: Transferring amount exceeds daily limit!");
                }else if(targetAccount instanceof SavingAccount){
                    throw new SavingTransferLimitException("Error: Saving account can only transfer to check account!");
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
