package application.addProduct;

/**
 * Enum for fields of product objects.
 *
 * @author David Spencer
 * @version 1.0
 */
public enum AddProductEnum {
    CODE("Product code: "),
    NAME("Product name: "),
    IMAGE("Product image: "),
    DESCRIPTION("Description: "),
    INGREDIENTS("Ingredients: "),
    PRICE("Price /0.5kg in pence: "),
    QUANTITY("Quantity delivered (kg): ");

    private String title;

    /**
     * Constructor for the enum
     * @param title the field title
     */
    AddProductEnum(String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return title;
    }

    /**
     * Returns alert text for InvalidFieldException.
     * @return description for an alert
     */
    public String getInvalidFieldDescription() {
        if (this == CODE) {
            return "Please enter a four digit code for this product.";
        }
        else if (this == NAME) {
            return "Please enter a valid name for this product.";
        }
        else if (this == IMAGE) {
            return "Please enter a valid image URL or leave the image field empty.";
        }
        else if (this == DESCRIPTION) {
            return "Please enter a valid description for this product.";
        }
        else if (this == INGREDIENTS) {
            return "Please enter this product's ingredients list, separated with commas.";
        }
        else if (this == PRICE) {
            return "Please enter this product's price per 500g, in pence.";
        }
        else if (this == QUANTITY) {
            return "Please enter the quantity of this product being added, in kilograms.";
        }
        return "The \"" + title + "\" field contains invalid input.";
    }

    /**
     * Returns alert text for StringLengthExceededException.
     * @return description for an alert
     */
    public String getStringLengthExceededDescription()
    {
        return "The \"" + title + "\" field contains too much text. Please enter something shorter.";
    }
}
