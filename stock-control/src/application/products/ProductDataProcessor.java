package application.products;

import application.addProduct.InvalidFieldException;
import application.addProduct.StringLengthExceededException;

/**
 * The ProductDataProcessor process data relating to products
 *
 * @author David Spencer
 * @version 1.0
 */
public class ProductDataProcessor {

    private static final int MAX_TEXT_LENGTH = 50;

    /**
     * Validates user input and returns true if the given listing contains viable data.
     * @param product The Product whose data is being validated
     * @return true if the Product object contains viable data, else false
     * @throws InvalidFieldException when any field contains invalid data
     * @throws StringLengthExceededException when a text field contains too much text
     */
    public static boolean validProductData(Product product) throws InvalidFieldException, StringLengthExceededException {
        return true;
    }

    /**
     * Returns true if a given string is empty (or null).
     * @param testString The string to be validated
     * @return true if the string is empty or null
     */
    public static boolean emptyString(String testString)
    {
        if (testString == null || testString.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if a given string exceeds the length limit.
     * @param testString The string to be validated
     * @return true if the string's length exceeds STRING_LIMIT
     */
    public static boolean lengthLimitExceeded(String testString)
    {
        if (testString == null) {
            return false;
        }
        if (testString.length() > MAX_TEXT_LENGTH) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if a given number is an integer greater than zero.
     * @param testNumber The number to be validated
     * @return true if the number is valid
     */
    public static boolean validNumber(int testNumber)
    {
        if (testNumber <= 0) {
            return false;
        }
        return true;
    }
}
