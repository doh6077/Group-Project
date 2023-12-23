package BankAccount;
/**
*Unique account ID generator for user accounts*/

import java.util.Random;

public class AccountIDGenerator {
    String accountID;

    /**
    *Randomly generate unique account ID from integer 1 to 10 in length of 10 for user accounts
    @param 
    @return String accountID: unique account ID of a bank account*/
    public static String generateAccountID() {
        Random random = new Random();
        StringBuilder accountID = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            accountID.append(digit);
        }

        return accountID.toString();
    }
}
