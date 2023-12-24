
package StrategyFactory;
/**
*Use factory model to dynamically determine different transfer strategies based on types of bank accounts. 
*Check accounts use transfer method tailored for check accounts
*Savings accounts use transfer method tailored for savings accounts */
 

import java.util.HashMap;

import java.util.Map;

 

import BankAccount.*;

import DepositStrategy.CheckDeposit;

import DepositStrategy.SavingDeposit;

import TransferStrategy.*;

import WithdrawStrategy.WithdrawStrategy;

 

public class TransferStrategyFactory {
    /*Map different transfer methods for check account and savings account*/
    private static final Map<Class<? extends BankAccount>, TransferStrategy> CONTAINER = new HashMap<>();
    static {
        CONTAINER.put(CheckAccount.class, new CheckTransfer());
        CONTAINER.put(SavingAccount.class, new SavingTransfer());
    }

    /*Get specific transfer strategy based on bank account type*/
    public static TransferStrategy getTransferStrategy(BankAccount account) {
        return CONTAINER.get(account.getClass());
    }

 }


