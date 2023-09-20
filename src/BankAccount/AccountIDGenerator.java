package BankAccount;

import java.util.Random;

public class AccountIDGenerator {
    String accountID;

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
