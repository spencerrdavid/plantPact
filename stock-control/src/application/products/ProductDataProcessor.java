package application.products;

import application.addProduct.AddProductEnum;
import application.addProduct.InvalidFieldException;
import application.addProduct.StringLengthExceededException;

/**
 * The ProductDataProcessor process data relating to products
 *
 * @author David Spencer
 * @version 1.0
 */
public class ProductDataProcessor {

    private static final int MAX_TEXT_LENGTH = 10;
    private static final int MAX_DIGIT_LENGTH = 6;

    /**
     * Validates user input and returns true if the given listing contains viable data.
     * @param product The Product whose data is being validated
     * @return true if the Product object contains viable data, else false
     * @throws InvalidFieldException when any field contains invalid data
     * @throws StringLengthExceededException when a text field contains too much text
     */
    public static boolean validProductData(Product product) throws InvalidFieldException, StringLengthExceededException {
        for (AddProductEnum field : AddProductEnum.values()) {
            switch (field) {
                case ID:
                    // id (already validated as non-negative integer) must not be zero
                    if (String.valueOf(product.getId()).length() > MAX_DIGIT_LENGTH) {
                        throw new StringLengthExceededException(field);
                    }
                    if (product.getId() == 0) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case CODE:
                    // code must be four digits
                    if (product.getCode().length() != 4) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case NAME:
                    if (product.getName().length() > MAX_TEXT_LENGTH) {
                        throw new StringLengthExceededException(field);
                    }
                    break;
                case IMAGE:
                    // image string validation already handled within Product class
                    break;
                case PRICE:
                    // price (already validated as non-negative integer) must not be zero
                    if (String.valueOf(product.getPrice()).length() > MAX_DIGIT_LENGTH) {
                        throw new StringLengthExceededException(field);
                    }
                    if (product.getPrice() == 0) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case QUANTITY:
                    // storeQuantity (already validated as non-negative integer) must not be zero
                    if (String.valueOf(product.getStoreQuantity()).length() > MAX_DIGIT_LENGTH) {
                        throw new StringLengthExceededException(field);
                    }
                    if (product.getStoreQuantity() == 0) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case DESCRIPTION:
                    if (product.getDescription().length() > MAX_TEXT_LENGTH) {
                        throw new StringLengthExceededException(field);
                    }
                    break;
                case INGREDIENTS:
                    if (product.getIngredients().length() > MAX_TEXT_LENGTH) {
                        throw new StringLengthExceededException(field);
                    }
                    break;
            }
        }
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

    /**
     * Checks whether a given string represents a non-negative integer.
     * @param str The string being checked
     * @return true if the string represents a non-negative integer, else false
     */
    public static boolean isPositiveInteger(String str)
    {
        try {
            int test = Integer.parseInt(str);
            if (test >= 0) {
                return true;
            }
        } catch(NumberFormatException e){
            return false;
        }
        return false;
    }
}
