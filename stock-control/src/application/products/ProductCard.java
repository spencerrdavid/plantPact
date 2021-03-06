package application.products;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
        if (image.getImage().isError()) {
            System.out.println("Error loading image for " + product.getName());
            image.getImage().getException().printStackTrace();
        } else {
            System.out.println("Successfully loaded image for " + product.getName());
        }
        image.setFitHeight(200);
        image.setFitWidth(200);
        image.setOnMouseClicked((MouseEvent e) -> System.out.println("clicked " + product.getName()));
        Label nameLabel = new Label(product.getName());
        Label totalQuantityLabel = new Label(product.getTotalStockQuantity() + "kg in stock");
        for (Label label : new Label[] {nameLabel, totalQuantityLabel}) {
            label.setId("text-label");
        }
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setId("name-label");
        VBox quantities = new VBox(totalQuantityLabel);
        quantities.setId("quantities-vbox");
        setId("card-vbox");
        this.getChildren().addAll(image, nameLabel, quantities);
    }

    /**
     * Gets this card's product.
     * @return the Product represented by this card
     */
    public Product getProduct() {
        return product;
    }

}
