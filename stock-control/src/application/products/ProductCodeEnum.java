package application.products;

/**
 * Enum for product category codes.
 *
 * @author David Spencer
 * @version 1.0
 */
public enum ProductCodeEnum {

    BEANS("00"),
    NUTS("10"),
    FLOUR("20"),
    PASTA("30"),
    RICE("31"),
    GRAINS("40"),
    FRUIT("50"),
    CHOCOLATE("60");

    private String code;

    ProductCodeEnum(String code)
    {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
