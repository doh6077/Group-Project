package Exception;

public class ExcessTransferException extends Exception{
    public String message;

    public ExcessTransferException(String message){
        super(message);
    }
}
