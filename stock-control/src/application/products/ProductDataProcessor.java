package application.products;

import application.addProduct.AddProductEnum;
import application.addProduct.InvalidFieldException;
import application.addProduct.StringLengthExceededException;

/**
 * The ProductDataProcessor processes and validates product data.
 *
 * @author David Spencer
 * @version 1.0
 */
public class ProductDataProcessor
{
    private static final int MAX_TEXT_LENGTH = 150;
    private static final int MAX_DIGIT_LENGTH = 6;
    private static final int CODE_LENGTH = 4;

    /**
     * Validates user input and returns true if the given listing contains viable data.
     * @param product the Product whose data is being validated
     * @return true if the Product object contains viable data, else false
     * @throws InvalidFieldException when any field contains invalid data
     * @throws StringLengthExceededException when a text field contains too much text
     */
    public static boolean validProductData(Product product) throws InvalidFieldException, StringLengthExceededException {
        for (AddProductEnum field : AddProductEnum.values()) {
            switch (field) {
                case CODE:
                    // code must be four digits
                    if (emptyString(product.getCode()) || product.getCode().length() != CODE_LENGTH) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case NAME:
                    if (lengthLimitExceeded(product.getName(), MAX_TEXT_LENGTH)) {
                        throw new StringLengthExceededException(field);
                    }
                    if (emptyString(product.getName())) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case IMAGE:
                    // image string validation already handled within Product class
                    break;
                case DESCRIPTION:
                    if (lengthLimitExceeded(product.getDescription(), MAX_TEXT_LENGTH)) {
                        throw new StringLengthExceededException(field);
                    }
                    if (emptyString(product.getDescription())) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case INGREDIENTS:
                    if (lengthLimitExceeded(product.getIngredients(), MAX_TEXT_LENGTH)) {
                        throw new StringLengthExceededException(field);
                    }
                    if (emptyString(product.getIngredients())) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case PRICE:
                    // price (already validated as non-negative integer) must not be zero
                    if (lengthLimitExceeded(String.valueOf(product.getPrice()), MAX_DIGIT_LENGTH)) {
                        throw new StringLengthExceededException(field);
                    }
                    if (product.getPrice() == 0) {
                        throw new InvalidFieldException(field);
                    }
                    break;
                case QUANTITY:
                    // storeQuantity (already validated as non-negative integer) must not be zero
                    if (lengthLimitExceeded(String.valueOf(product.getStoreQuantity()), MAX_DIGIT_LENGTH)) {
                        throw new StringLengthExceededException(field);
                    }
                    if (product.getStoreQuantity() == 0) {
                        throw new InvalidFieldException(field);
                    }
                    break;
            }
        }
        return true;
    }

    /**
     * Returns true if a given string is empty (or null).
     * @param testString the string to be validated
     * @return true if the string is empty or null, else false
     */
    private static boolean emptyString(String testString) {
        return (testString == null || testString.trim().isEmpty());
    }

    /**
     * Returns true if a given string exceeds the given length limit, else false.
     * @param testString the string to be validated
     * @return true if the string's length exceeds limit
     */
    private static boolean lengthLimitExceeded(String testString, int limit) {
        return (testString != null && testString.length() > limit);
    }

    /**
     * Checks whether a given string represents a non-negative integer, else false.
     * @param str the string being checked
     * @return true if the string represents a non-negative integer
     */
    public static boolean isPositiveInteger(String str) {
        try {
            int test = Integer.parseInt(str);
            if (test >= 0) {
                return true;
            }
        }
        catch(NumberFormatException e){
            return false;
        }
        return false;
    }
}
