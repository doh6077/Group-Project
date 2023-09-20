package Exception;

public class SavingTransferLimitException extends Exception{
    public String message;

    public SavingTransferLimitException(String message){
        super(message);
    }
}
