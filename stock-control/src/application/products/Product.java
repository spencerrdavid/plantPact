package application.products;

import application.addProduct.AddProductEnum;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The Product class represents products within the application.
 *
 * @author David Spencer
 * @version 1.0
 */
public class Product
{
    private static final String DEFAULT_IMAGE =
            "https://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/cat1/MissingImage_BB.png";
    private int id;
    private static int idCounter = 0;
    private String code;
    private String name;
    private String image;   // URL for image
    private String description;
    private String ingredients;
    private int price;  // price per 0.5 kg (pence)
    private int storeQuantity;  // quantity in storage (kilograms)
    private int floorQuantity;  // quantity on shop floor (kilograms)

    /**
     * Constructor for Product objects.
     */
    public Product(String code, String name, String image, String description,
                   String ingredients, int price, int quantity)
    {
        this.id = idCounter++;
        this.code = code;
        this.name = name;
        if (image.isEmpty()) {
            this.image = DEFAULT_IMAGE;
        } else {
            setImage(image);
        }
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
        // new product quantities are initially deposited into storage
        this.storeQuantity = quantity;
        this.floorQuantity = 0;
    }

    /**
     * The default constructor for this class
     */
    public Product()
    {
        image = DEFAULT_IMAGE;
        price = 0;
        storeQuantity = 0;
        floorQuantity = 0;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getPrice() {
        return price;
    }

    public int getStoreQuantity() {
        return storeQuantity;
    }

    public int getFloorQuantity() {
        return floorQuantity;
    }

    public int getTotalStockQuantity() {
        return storeQuantity + floorQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks that input string is in URL form and sets the image field accordingly.
     * @param image The URL string to be checked
     */
    public void setImage(String image) {
        try {
            new URL(image);
            this.image = image;
        }
        catch (MalformedURLException e) {
            this.image = DEFAULT_IMAGE;
            System.err.println("image string not a valid URL: " + e.toString());
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Updates the quantity of this product in storage.
     * @param weight integer amount of the product, in kilograms
     */
    public void updateStoreQuantity(int weight) {
        this.storeQuantity = storeQuantity + weight;
    }

    /**
     * Updates the quantity of this product on shop floor.
     * @param weight integer amount of the product, in kilograms
     */
    public void updateFloorQuantity(int weight) {
        this.floorQuantity = floorQuantity + weight;
    }

    /**
     * Sets each of this object's fields, according to given input.
     * @param input String representation of field value
     * @param type AddProductEnum identifying the field to be set
     */
    public void setFieldFromInput(String input, AddProductEnum type) {
        switch (type) {
            case CODE:
                code = input;
                break;
            case NAME:
                name = input;
                break;
            case IMAGE:
                if (!input.isEmpty()) {
                    setImage(input);
                } else {
                    image = DEFAULT_IMAGE;
                }
                break;
            case DESCRIPTION:
                description = input;
                break;
            case INGREDIENTS:
                ingredients = input;
                break;
            case PRICE:
                if (ProductDataProcessor.isPositiveInteger(input)) {
                    price = Integer.parseInt(input);
                } else {
                    price = 0;
                }
                break;
            case QUANTITY:
                if (ProductDataProcessor.isPositiveInteger(input)) {
                    storeQuantity = Integer.parseInt(input);
                } else {
                    storeQuantity = 0;
                }
                break;
        }
    }

    /**
     * Checks whether this product's code matches that of a given category.
     * @param type the type of product being checked for
     */
    public boolean codeMatches(ProductCodeEnum type) {
        return code.substring(0, 2).equals(type.toString());
    }

    /**
     * Provides a string representation of this Product's fields.
     * @return String representation of this Product
     */
    @Override
    public String toString() {
        StringBuilder productDetails = new StringBuilder();
        productDetails.append("ID: ");
        productDetails.append(id);
        productDetails.append("\n");
        productDetails.append("Product Name: ");
        productDetails.append(name);
        productDetails.append("\n");
        productDetails.append("Code: ");
        productDetails.append(code);
        productDetails.append("\n");
        productDetails.append("Description: ");
        productDetails.append(description);
        productDetails.append("\n");
        productDetails.append("Ingredients: ");
        productDetails.append(ingredients);
        productDetails.append("\n");
        productDetails.append("Price per 500g: £");
        productDetails.append(new BigDecimal(price).movePointLeft(2));
        productDetails.append("\n");
        productDetails.append("Quantity in stock: ");
        productDetails.append(getTotalStockQuantity());
        productDetails.append("kg");
        productDetails.append("\n");
        productDetails.append("Image URL: ");
        productDetails.append(image);
        productDetails.append("\n");
        return productDetails.toString();
    }
}
