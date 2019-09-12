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
        cardList = FXCollections.observableArrayList();
//        Product test = new Product(0, "0000", "food", "", "", 0,50);
//        ProductCard testCard = new ProductCard(test);
//        Product test1 = new Product(0, "0000", "food", "", "", 0,60);
//        ProductCard testCard1 = new ProductCard(test1);
//        Product test2 = new Product(0, "0000", "food", "", "", 0,70);
//        ProductCard testCard2 = new ProductCard(test2);
//        cardList.add(testCard);
//        cardList.add(testCard1);
//        cardList.add(testCard2);
        cardListView = new ListView<>();
        cardListView.setOrientation(Orientation.HORIZONTAL);
        cardListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cardListView.getSelectionModel().clearSelection();
        cardListView.setFocusTraversable(false);
//        cardListView.setItems(cardList);
        emptyLabel = new Label("No products have been added yet.");
        emptyLabel.setId("empty-label");
        setCenter(emptyLabel);

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
}
