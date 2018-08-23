package ZJUNK;

import utility.Constants;

public class Validator
{
    public static void ValidatePropertyValue(int value, String propertyName)
    {
        if (value <= 0)
        {
            throw new IllegalArgumentException(String.format(Constants.S_MUST_BE_A_POSITIVE_INTEGER, propertyName));
        }
    }

    public static void ValidateModelLength(String value, int minModelLength)
    {
        if (value.length() < minModelLength)
        {
            throw new IllegalArgumentException(String.format(Constants.MODEL_S_NAME_MUST_BE_AT_LEAST_S_SYMBOLS_LONG, minModelLength));
        }
    }
}
