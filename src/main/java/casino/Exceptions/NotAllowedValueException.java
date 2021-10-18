package casino.Exceptions;

public class NotAllowedValueException extends Exception{
    public NotAllowedValueException(){
        super("you are using an unaccepted Value");
    }
}
