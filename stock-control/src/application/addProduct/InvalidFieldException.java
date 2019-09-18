package application.addProduct;

/**
 * An exception thrown when a field contains invalid user input.
 */
public class InvalidFieldException extends Exception
{
    private AddProductEnum type;

    public InvalidFieldException(AddProductEnum type)
    {
        super(type.toString());
        this.type = type;
    }

    public AddProductEnum getType() {
        return type;
    }
}
