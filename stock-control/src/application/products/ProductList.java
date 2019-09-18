package application.products;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

/**
 * The ProductList class contains a list of ProductCard objects.
 *
 * @author David Spencer
 * @version 1.0
 */
public class ProductList extends BorderPane
{
    private ObservableList<ProductCard> cardList;
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
        cardList = FXCollections.observableArrayList();
        emptyLabel = new Label("No products have been added yet.");
        emptyLabel.setId("empty-label");
//        setCenter(emptyLabel);
        setTestProducts();  // for testing
        setCenter(cardListView);

    }

    /**
     * Adds a product to the list.
     * @param product The product to be added to the list.
     */
    public void addProduct(Product product) {
        ProductCard newCard = new ProductCard(product);
        if (cardList.isEmpty()) {
            this.setCenter(cardListView);
            cardList.add(newCard);
            cardListView.setItems(cardList);
        } else {
            cardList.add(newCard);
        }
    }

    /**
     * Generates some ProductCard objects for testing.
     */
    private void setTestProducts() {

        Product test = new Product("0001", "Red kidney beans",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-0407-0265.png",
                "Dried dark red kidney beans", "red kidney beans", 100, 100);
        ProductCard testCard = new ProductCard(test);
        cardList.add(testCard);

        Product test1 = new Product("1001", "Raw almonds",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/000120_Unsalted-Almonds-Dry-Roasted_cluster.png",
                "Unsalted raw almonds", "almonds", 440, 50);
        ProductCard testCard1 = new ProductCard(test1);
        cardList.add(testCard1);

        Product test2 = new Product("1002", "Raw cashews",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-0125-0199.png",
                "Unsalted raw cashew nuts", "cashew nuts", 650, 50);
        ProductCard testCard2 = new ProductCard(test2);
        cardList.add(testCard2);

        Product test3 = new Product("3001", "Fusilli",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-1644-0298.png",
                "Fusilli pasta, great for baked dishes", "durum wheat semolina, niacin, iron, riboflavin, thiamine mononitrate, folic acid",
                600, 150);
        ProductCard testCard3 = new ProductCard(test3);
        cardList.add(testCard3);

        Product test4 = new Product("3102", "Brown long grain rice",
                "http://www.bulkbarn.ca/app_themes/BulkBarn/Images/assets/products/full/BB_150910-1602-0295.png",
                "Whole grain rice, ideal for savoury dishes", "brown long grain rice", 650, 100);
        ProductCard testCard4 = new ProductCard(test4);
        cardList.add(testCard4);

        // add the list of cards to the list view
        cardListView.setItems(cardList);
    }
}
