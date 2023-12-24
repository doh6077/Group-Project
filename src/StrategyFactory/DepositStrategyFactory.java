package StrategyFactory;

/**
*Use Factory model to dynamically determine different deposit strategies based on types of bank accounts. 
*Check accounts use deposit method tailored for check accounts
*Savings accounts use deposit method tailored for savings accounts */

import java.util.HashMap;
import java.util.Map;
import BankAccount.*;
import DepositStrategy.*;

public class DepositStrategyFactory {
    /*Map different deposit methods for check account and savings account*/
    private static final Map<Class<? extends BankAccount>, DepositStrategy> CONTAINER = new HashMap<>();
    static {
        CONTAINER.put(CheckAccount.class, new CheckDeposit());
        CONTAINER.put(SavingAccount.class, new SavingDeposit());
    }

/*Get specific deposit strategy based on bank account type*/
    public static DepositStrategy getDepositStrategy(BankAccount account) {
        return CONTAINER.get(account.getClass());
    }
}
