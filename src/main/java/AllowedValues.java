import Exceptions.NotAllowedValueException;

/**
 * this class is used to represent all the possible values that can be given to a card
 * @author Abdellah NAJI
 * @version 0.1
 */
public class AllowedValues {
    /**
     * possible values
     */
    private static final String[] allowedValues = {"A","2","3","4","5","6","7","8","9","10","V","D","R","A"};

    /**
     * get the string value that can be given to a card
     * if this class get not allowed card in input it will return a NotAllowedValueException
     * @param number the number wich you need the String value
     * @return the string value
     * @throws NotAllowedValueException exception that represent that the value is not allowed
     */
    public static String getValue(int number) throws NotAllowedValueException {
        if(number>=1 && number<=14)
            return allowedValues[number-1];
        else
            throw new NotAllowedValueException();
    }

    public static int getMaxValueAllowed(){
        return 13;
    }

    public static int getMinValueAllowed(){
        return 1;
    }
}
