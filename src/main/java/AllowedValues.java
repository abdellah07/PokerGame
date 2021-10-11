import Exceptions.NotAllowedValue;

public class AllowedValues {
    private static final String[] allowedValues = {"A","2","3","4","5","6","7","8","9","10","V","D","R","A"};

    public static String getValue(int number) throws NotAllowedValue {
        if(number>=1 && number<=14)
            return allowedValues[number-1];
        else
            throw new NotAllowedValue();
    }

    public static int getMaxValueAllowed(){
        return 13;
    }

    public static int getMinValueAllowed(){
        return 1;
    }
}
