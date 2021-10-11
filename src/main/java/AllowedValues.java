import Exceptions.NotAllowedValueException;

import java.util.Arrays;

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
    public static String getValue(int number) {
        if(number>=1 && number<=14)
            return allowedValues[number-1];
        else
            return "";
    }

    public static int getIntValue(String value) {
        for(int i = 1;i<=14;i++){
            if(allowedValues[i].equals(value))
                return i;
        }
        return 0;
    }

    public static boolean isAllowedValue(String Value){
        return Arrays.asList(allowedValues).contains(Value);
    }

    public static int getMaxValueAllowed(){
        return 13;
    }

    public static int getMinValueAllowed(){
        return 1;
    }
}
