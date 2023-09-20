package Exception;

public class InvalidInputException extends Exception{
    public String message;

    public InvalidInputException(String message){
        super(message);
    }
}
