package application;

/**
 * The Product class represents products within the application.
 *
 * @author David Spencer
 * @version 1.0
 */
public class Product
{

    private int id;
    private String code;
    private String name;
    private String image;   // URL for image
    private String description;
    private String ingredients;
    private int price;  // price per 0.5 kg (pence)
    private int storeQuantity;  // weight in storage (kilograms)
    private int floorQuantity;  // weight on shop floor (kilograms)

    /**
     * Constructor for Product objects.
     */
    public Product(int id, String code, String name, String description,
                    String ingredients, int price, int quantity)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.image = "";
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
        this.storeQuantity = quantity;
        this.floorQuantity = 0;
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

    public void setImage(String image) {
        this.image = image;
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
     * @param weight The amount of the product in kilograms
     */
    public void updateStoreQuantity(int weight) {
        this.storeQuantity = storeQuantity + weight;
    }

    /**
     * Updates the quantity of this product on shop floor.
     * @param weight The amount of the product in kilograms
     */
    public void updateFloorQuantity(int weight) {
        this.floorQuantity = floorQuantity + weight;
    }
}
