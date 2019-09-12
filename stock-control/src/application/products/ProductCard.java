package application.products;

import application.products.Product;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

/**
 * Each ProductCard displays data about one Product.
 *
 * @author David Spencer
 * @version 1.0
 */
public class ProductCard extends VBox
{
    private Product product;

    /**
     * Constructor for ProductCard objects.
     */
    public ProductCard(Product product)
    {
        super();
        this.product = product;
        ImageView image = new ImageView(product.getImage());
        image.setFitHeight(200);
        image.setFitWidth(200);
        image.setOnMouseClicked((MouseEvent e) -> System.out.println("clicked"));
        Label nameLabel = new Label(product.getName());
        Label storeQuantityLabel = new Label(String.valueOf(product.getStoreQuantity()));
        Label floorQuantityLabel = new Label(String.valueOf(product.getFloorQuantity()));
        for (Label label : new Label[] {nameLabel, storeQuantityLabel, floorQuantityLabel}) {
            label.setId("text-label");
        }
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setId("name-label");
        HBox quantities = new HBox(storeQuantityLabel, floorQuantityLabel);
        quantities.setId("quantities-hbox");
        setId("card-vbox");
        this.getChildren().addAll(image, nameLabel, quantities);
    }

}