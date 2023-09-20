package Exception;

public class SavingThresholdException extends Exception{
    public String message;

    public SavingThresholdException(String message){
        super(message);
    }
}
