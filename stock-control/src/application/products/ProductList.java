package application.products;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The ProductList class contains a list of ProductCard objects.
 *
 * @author David Spencer
 * @version 1.0
 */
public class ProductList extends BorderPane
{
    private List<ProductCard> products;
    private ListView<ProductCard> cardListView;
    private Label emptyLabel;

    /**
     * Constructor for ProductCard objects.
     */
    public ProductList()
    {
        super();
        cardListView = new ListView<>();
        cardListView.setOrientation(Orientation.HORIZONTAL);
        cardListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cardListView.getSelectionModel().clearSelection();
        cardListView.setFocusTraversable(false);
        cardListView.setPrefWidth(800);
        products = new ArrayList<>();
        // for testing
        setTestProducts();
        cardListView.setItems(FXCollections.observableArrayList(products));
        setCenter(cardListView);
        emptyLabel = new Label("No products have been added yet.");
        emptyLabel.setId("empty-label");
//        setCenter(emptyLabel);
    }

    /**
     * Adds a product to the list.
     * @param product The product to be added to the list.
     */
    public void addProduct(Product product) {
        ProductCard newCard = new ProductCard(product);
        if (products.isEmpty()) {
            this.setCenter(cardListView);
            products.add(newCard);
            cardListView.setItems(FXCollections.observableArrayList(products));
        } else {
            products.add(newCard);
        }
    }

    /**
     * Toggles between different product categories.
     * @param type The type of product to be displayed.
     */
    public void toggleProducts(String type) {
        switch (type) {
            case "all":
                cardListView.setItems(FXCollections.observableArrayList(products));
            case "beans":
                filterListByProductCode(ProductCodeEnum.BEANS);
            case "nuts":
                filterListByProductCode(ProductCodeEnum.NUTS);
            case "flour":
                filterListByProductCode(ProductCodeEnum.FLOUR);
            case "pasta":
                filterListByProductCode(ProductCodeEnum.PASTA);
            case "rice":
                filterListByProductCode(ProductCodeEnum.RICE);
            case "grains":
                filterListByProductCode(ProductCodeEnum.GRAINS);
            case "fruit":
                filterListByProductCode(ProductCodeEnum.FRUIT);
            case "chocolate":
                filterListByProductCode(ProductCodeEnum.CHOCOLATE);
        }
    }

    /**
     * Updates the list of cards according to a given product type.
     * @param type the selected product type
     */
    private void filterListByProductCode(ProductCodeEnum type) {
        cardListView.setItems(FXCollections.observableArrayList(products.stream()
                .filter(card -> card.getProduct().codeMatches(type))
                .collect(Collectors.toList())));
    }

    /**
     * Generates some ProductCard objects for testing.
     */
    private void setTestProducts() {

        Product test = new Product("0001", "Red kidney beans",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-0407-0265.png",
                "Dried dark red kidney beans", "red kidney beans", 100, 100);
        ProductCard testCard = new ProductCard(test);
        products.add(testCard);

        Product test1 = new Product("1001", "Raw almonds",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/000120_Unsalted-Almonds-Dry-Roasted_cluster.png",
                "Unsalted raw almonds", "almonds", 440, 50);
        ProductCard testCard1 = new ProductCard(test1);
        products.add(testCard1);

        Product test2 = new Product("1002", "Raw cashews",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-0125-0199.png",
                "Unsalted raw cashew nuts", "cashew nuts", 650, 50);
        ProductCard testCard2 = new ProductCard(test2);
        products.add(testCard2);

        Product test3 = new Product("3001", "Fusilli",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-1644-0298.png",
                "Fusilli pasta, great for baked dishes", "durum wheat semolina, niacin, iron, riboflavin, thiamine mononitrate, folic acid",
                600, 150);
        ProductCard testCard3 = new ProductCard(test3);
        products.add(testCard3);

        Product test4 = new Product("3102", "Brown long grain rice",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-1602-0295.png",
                "Whole grain rice, ideal for savoury dishes", "brown long grain rice", 650, 100);
        ProductCard testCard4 = new ProductCard(test4);
        products.add(testCard4);
    }
}
