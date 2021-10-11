package Exceptions;

public class EmptyDeckException extends Exception{
    EmptyDeckException(){
        super("No more available cards in the deck");
    }
}
