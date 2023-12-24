package StrategyFactory;

/**
*Use factory model to dynamically determine different withdrawal strategies based on types of bank accounts. 
*Check accounts use withdrawal method tailored for check accounts
*Savings accounts use withdrawal method tailored for savings accounts */

import java.util.HashMap;
import java.util.Map;
import BankAccount.*;
import DepositStrategy.CheckDeposit;
import DepositStrategy.DepositStrategy;
import DepositStrategy.SavingDeposit;
import WithdrawStrategy.*;

 
public class WithdrawStrategyFactory {
    private static final Map<Class<? extends BankAccount>, WithdrawStrategy> CONTAINER = new HashMap<>();
    static {
        CONTAINER.put(CheckAccount.class, new CheckWithdraw());
        CONTAINER.put(SavingAccount.class, new SavingWithdraw());
    }

 /*Get specific withdrawal strategy based on the type of bank account*/
    public static WithdrawStrategy getWithdrawStrategy(BankAccount account) {
        return CONTAINER.get(account.getClass());
    }

}
