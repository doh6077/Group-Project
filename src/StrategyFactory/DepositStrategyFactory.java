package StrategyFactory;

import java.util.HashMap;
import java.util.Map;
import BankAccount.*;
import DepositStrategy.*;

public class DepositStrategyFactory {
    private static final Map<Class<? extends BankAccount>, DepositStrategy> CONTAINER = new HashMap<>();
    static {
        CONTAINER.put(CheckAccount.class, new CheckDeposit());
        CONTAINER.put(SavingAccount.class, new SavingDeposit());
    }

    public static DepositStrategy getDepositStrategy(BankAccount account) {
        return CONTAINER.get(account.getClass());
    }
}
