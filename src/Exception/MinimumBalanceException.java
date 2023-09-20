package Exception;

public class MinimumBalanceException extends Exception{
    public String message;

    public MinimumBalanceException(String message){
        super(message);
    }
}
