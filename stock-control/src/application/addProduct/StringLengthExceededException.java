package application.addProduct;

/**
 * An exception thrown when a text field contains too much text.
 */
public class StringLengthExceededException extends Exception
{
    private AddProductEnum type;

    public StringLengthExceededException(AddProductEnum type)
    {
        super(type.toString());
        this.type = type;
    }

    public AddProductEnum getType() {
        return type;
    }
}
