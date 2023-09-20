package StrategyFactory;

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

    public static WithdrawStrategy getWithdrawStrategy(BankAccount account) {
        return CONTAINER.get(account.getClass());
    }

}