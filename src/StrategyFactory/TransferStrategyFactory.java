/*package StrategyFactory;

import java.util.HashMap;
import java.util.Map;

import BankAccount.*;
import TransferStrategy.*;
import WithdrawStrategy.CheckWithdraw;
import WithdrawStrategy.SavingWithdraw;
import WithdrawStrategy.WithdrawStrategy;

public class TransferStrategyFactory {
    private static final Map<BankAccount, TransferStrategy> CONTAINER = new HashMap<>();
    static {
        CheckAccount checkAccount = new CheckAccount();
        SavingAccount savingAccount = new SavingAccount();
        CONTAINER.put(checkAccount, new CheckTransfer());
        CONTAINER.put(savingAccount, new SavingTransfer());
    }

    public static TransferStrategy getTransferStrategy(BankAccount account) {
        return CONTAINER.get(account);
    }//
    private static final Map<Class<? extends BankAccount>, TransferStrategy> CONTAINER = new HashMap<>();
    static {
        CONTAINER.put(CheckAccount.class, new CheckTransfer());
        CONTAINER.put(SavingAccount.class, new SavingTransfer());
    }

    public static TransferStrategy getTransferStrategy(BankAccount account) {
        return CONTAINER.get(account.getClass());
    }*/

package StrategyFactory;

 

import java.util.HashMap;

import java.util.Map;

 

import BankAccount.*;

import DepositStrategy.CheckDeposit;

import DepositStrategy.SavingDeposit;

import TransferStrategy.*;

import WithdrawStrategy.WithdrawStrategy;

 

public class TransferStrategyFactory {

    private static final Map<Class<? extends BankAccount>, TransferStrategy> CONTAINER = new HashMap<>();
    static {
        CONTAINER.put(CheckAccount.class, new CheckTransfer());
        CONTAINER.put(SavingAccount.class, new SavingTransfer());
    }

    public static TransferStrategy getTransferStrategy(BankAccount account) {
        return CONTAINER.get(account.getClass());
    }

 }


