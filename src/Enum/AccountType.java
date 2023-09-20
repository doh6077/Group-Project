package Enum;

public enum AccountType {
    CHECKINGACCOUNT("checkingAccount"),
    SAVINGACCOUNT("savingAccount");

    private final String value;

    private AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}




