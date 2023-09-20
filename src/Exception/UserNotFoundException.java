package Exception;

public class UserNotFoundException extends Exception{
    public String message;

    public UserNotFoundException(){
        super("Error! User NOT FOUND!!!");
    }
}
