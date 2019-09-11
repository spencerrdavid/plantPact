package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.util.List;

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
        cardListView.setItems(cardList);
        emptyLabel = new Label("No products have been added yet.");
        emptyLabel.setId("empty-label");
        setCenter(emptyLabel);

    }

    /**
     * Adds a ProductCard to the list.
     * @param card The ProductCard to be added to the list
     */
    private void addCard(ProductCard card) {
        if (cardList.isEmpty()) {
            this.setCenter(cardListView);
        }
        cardList.add(card);
    }

}
